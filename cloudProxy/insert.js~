var MongoClient = require('mongodb').MongoClient;
var assert = require('assert');
var url = 'mongodb://localhost:27017/cloud_proxy';

MongoClient.connect(url, function(err, db) {
    assert.equal(null, err);
    insertPlans(db, function(result) {
        insertVms(db, result, function(result2) {
            insertCloud(db, result2, function(result3) {
                console.log(result3);
                db.close();
            });
        });
    });
});

var insertPlans = function(db, callback) {
    db.collection('plans').insert([
    {
        "provider" : "DIGITAL_OCEAN",
        "planNum" : 1,
        "monthlyRate" : 4.5,
        "cpu" : 1.8,
        "mem" : 512,
        "storage" : 250,
        "network" : 100
    },
    {
        "provider" : "DIGITAL_OCEAN",
        "planNum" : 2,
        "monthlyRate" : 5.0,
        "cpu" : 2.3,
        "mem" : 1024,
        "storage" : 500,
        "network" : 300
    },
    {
        "provider" : "AMAZON",
        "planNum" : 1,
        "monthlyRate" : 7.8,
        "cpu" : 3.0,
        "mem" : 2048,
        "storage" : 1000,
        "network" : 500
    },
    {
        "provider" : "AMAZON",
        "planNum" : 2,
        "monthlyRate" : 10.0,
        "cpu" : 3.0,
        "mem" : 4096,
        "storage" : 1000,
        "network" : 500
    }], function(err, result) {
        assert.equal(err, null);
        console.log("Inserted plans.");
        callback(result);
    });
};

var insertVms = function(db, result, callback) {
    db.collection('vms').insert([
    {
        "ip" : "203.111.23.24",
        "cpu" : 0,
        "mem" : 0,
        "storage" : 0,
        "network" : 0,
        "plan": result.ops[0]["_id"]
    },
    {
        "ip" : "203.111.23.25",
        "cpu" : 0,
        "mem" : 0,
        "storage" : 0,
        "network" : 0,
        "plan": result.ops[1]["_id"]
    },
    {
        "ip" : "126.11.23.24",
        "cpu" : 0,
        "mem" : 0,
        "storage" : 0,
        "network" : 0,
        "plan": result.ops[2]["_id"]
    },
    {
        "ip" : "126.11.23.25",
        "cpu" : 0,
        "mem" : 0,
        "storage" : 0,
        "network" : 0,
        "plan": result.ops[3]["_id"]
    }], function(err, result) {
        assert.equal(err, null);
        console.log("Inserted VMs.");
        callback(result);
    });
};

var insertCloud = function(db, result, callback) {
    db.collection('clouds').insert([
    {
        "username" : "donus",
        "password" : "1234",
        "provider" : "DIGITAL_OCEAN",
        "vms" : [
            result.ops[0]["_id"],
            result.ops[1]["_id"]
        ]
    },
    {
        "username" : "donus",
        "password" : "1234",
        "provider" : "AMAZON",
        "vms" : [
            result.ops[2]["_id"],
            result.ops[3]["_id"]
        ]
    }], function(err, result) {
        assert.equal(err, null);
        console.log("Inserted Cloud.");
        callback(result);
    });
};



