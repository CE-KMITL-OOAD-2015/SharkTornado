var MongoClient = require('mongodb').MongoClient;
var sleep = require('sleep');
var async = require('async');
var keypress = require('keypress');

var url = 'mongodb://localhost:27017/cloud_proxy';
var peak = false;

keypress(process.stdin);

process.stdin.on('keypress', function (ch, key) {
    //console.log('got "keypress"', key);
    if (key.name == 'q') {
        process.stdin.pause();
        console.log("Terminated");
        process.exit(1);
    }
    else if (key.name == 'p') {
        console.log("Is peak ? " + peak);
        peak = true;
    }
});

process.stdin.setRawMode(true);
process.stdin.resume();

async.whilst(
    function () { 
        return true; 
    },
    function (callback) {
        //console.log(c);

        MongoClient.connect(url, function(err, db) {
            if (err == null) {
                findAndUpdate(db, function() {
                    db.close();
                });
            }
        });

        setTimeout(callback, 500);
    },
    function (err) {}
);

var findAndUpdate = function(db, callback) {
    var cursor = db.collection('vms').find();

    cursor.toArray(function(err, vms) {
        if (err == null) {
            var realCount = 0;
            var realCount2 = 0;
            var len = vms.length;

            for (var count = 0; count < vms.length; count++) {
                db.collection('plans').findOne({"_id": vms[count]["plan"]}, function(err2, plan) {
                    if (err2 == null) {
                        var cpu = 0;
                        var mem = 0;
                        var storage = 0;
                        var network = 0;

                        if (peak) {
                            cpu = ((95*plan["cpu"])/100);
                            mem = ((95*plan["mem"])/100);
                            storage = ((95*plan["storage"])/100);
                            network = ((95*plan["network"])/100);
                        }
                        else {
                            cpu = Math.round(random(0.5, ((8*plan["cpu"])/10)) * 100) / 100;
                            mem = randomInt(128, ((8*plan["mem"])/10));
                            storage = randomInt(50, ((8*plan["storage"])/10));
                            network = randomInt(50, ((8*plan["network"])/10));
                        }

                        db.collection('vms').updateOne(
                            {
                                "_id": vms[realCount]["_id"]
                            },
                            {
                                $set: {
                                    "cpu": cpu,
                                    "mem": mem,
                                    "storage": storage,
                                    "network": network
                                }
                            }, function(err3, result) {
                                if (err3 == null) {
                                    realCount2++;

                                    if (realCount2 == len) {
                                        peak = false;
                                        callback();
                                    }
                                }
                            });

                        realCount++;
                    }
                });
            }
        }
    });
};

function random(low, high) {
    return Math.random() * (high - low) + low;
}

function randomInt(low, high) {
    return Math.floor(Math.random() * (high - low) + low);
}
