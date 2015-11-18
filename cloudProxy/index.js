var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var url = 'mongodb://localhost:27017/cloud_proxy';

MongoClient.connect(url, function(err, db) {
    assert.equal(null, err);

    findAndUpdate(db, function() {
        db.close();
    });
});

var findAndUpdate = function(db, callback) {
    var cursor = db.collection('vms').find();

    cursor.toArray(function(err, vms) {
        assert.equal(err, null);

        var realCount = 0;
        var realCount2 = 0;
        var len = vms.length;

        for (var count = 0; count < vms.length; count++) {
            db.collection('plans').findOne({"_id": vms[count]["plan"]}, function(err2, plan) {
                assert.equal(err2, null);

                db.collection('vms').updateOne(
                    {
                        "_id": vms[realCount]["_id"]
                    },
                    {
                        $set: {
                            "cpu": Math.round(random(0.5, plan["cpu"]) * 100) / 100,
                            "mem": randomInt(128, plan["mem"]),
                            "storage": randomInt(50, plan["storage"]),
                            "network": randomInt(50, plan["network"])
                        }
                    }, function(err3, result) {
                        assert.equal(err3, null);

                        realCount2++;

                        if (realCount2 == len)
                            callback();
                    });

                realCount++;
            });
        }
    });
};

function random(low, high) {
    return Math.random() * (high - low) + low;
}

function randomInt(low, high) {
    return Math.floor(Math.random() * (high - low) + low);
}
