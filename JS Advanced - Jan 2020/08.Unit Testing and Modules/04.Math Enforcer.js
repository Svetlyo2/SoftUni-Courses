let expect = require('chai').expect;

let mathEnforcer = {
    addFive: function (num) {
        if (typeof(num) !== 'number') {
            return undefined;
        }
        return num + 5;
    },
    subtractTen: function (num) {
        if (typeof(num) !== 'number') {
            return undefined;
        }
        return num - 10;
    },
    sum: function (num1, num2) {
        if (typeof(num1) !== 'number' || typeof(num2) !== 'number') {
            return undefined;
        }
        return num1 + num2;
    }
};

describe('mathEnforcer tests', function () {
    describe('addFive tests', function () {

        it('add ""=>undefined', function () {
            expect(mathEnforcer.addFive("")).to.equal(undefined);
        });
        it('add []=>undefined', function () {
            expect(mathEnforcer.addFive([])).to.equal(undefined);
        });
        it('add "5"=>undefined', function () {
            expect(mathEnforcer.addFive("5")).to.equal(undefined);
        });

        it('add {}=>undefined', function () {
            expect(mathEnforcer.addFive({})).to.equal(undefined);
        });
        it('add 5=>5', function () {
            expect(mathEnforcer.addFive(5)).to.equal(10);
        });
        it('add -5=>0', function () {
            expect(mathEnforcer.addFive(-5)).to.be.equal(0);
        });
        it('add -5.5=>0.5', function () {
            expect(mathEnforcer.addFive(-5.51)).to.be.closeTo(-0.51,0.01);
        });
    });
    describe('subtractTen tests', function () {
        it('subtractTen ""=>undefined', function () {
            expect(mathEnforcer.subtractTen("")).to.equal(undefined);
        });
        it('subtractTen []=>undefined', function () {
            expect(mathEnforcer.subtractTen([])).to.equal(undefined);
        });
        it('subtractTen "5"=>undefined', function () {
            expect(mathEnforcer.subtractTen("5")).to.equal(undefined);
        });

        it('subtractTen {}=>undefined', function () {
            expect(mathEnforcer.subtractTen({})).to.equal(undefined);
        });
        it('subtractTen 1=>--9', function () {
            expect(mathEnforcer.subtractTen(1)).to.equal(-9);
        });
        it('subtractTen -10=>-20', function () {
            expect(mathEnforcer.subtractTen(-10)).to.equal(-20);
        });
        it('subtractTen -5.500001=>-15.5', function () {
            expect(mathEnforcer.subtractTen(-5.5)).to.be.closeTo(-15.5,0.01);
        });
    });
    describe('sum tests', function () {
        it('sum 1,"1"=>undefined', function () {
            expect(mathEnforcer.sum(1,"1")).to.equal(undefined);
        });
        it('sum 1,"1"=>undefined', function () {
            expect(mathEnforcer.sum("1",1)).to.equal(undefined);
        });
        it('sum 1,[]=>undefined', function () {
            expect(mathEnforcer.sum([])).to.equal(undefined);
        });
        it('sum 1,"5"=>undefined', function () {
            expect(mathEnforcer.sum("5")).to.equal(undefined);
        });

        it('sum 1,{a:1}=>undefined', function () {
            expect(mathEnforcer.sum({})).to.equal(undefined);
        });
        it('sum 1,2=>3', function () {
            expect(mathEnforcer.sum(1,2)).to.equal(3);
        });
        it('sum 1,-2=>-1', function () {
            expect(mathEnforcer.sum(10,-2)).to.equal(8);
        });
        it('sum -1,-2=>-3', function () {
            expect(mathEnforcer.sum(-1,-2)).to.equal(-3);
        });
        it('sum -5.9,-4.5=>-10.4', function () {
            expect(mathEnforcer.sum(-5.9,-4.5)).to.be.closeTo(-10.4,0.01);
        });
    })

// const addTests=[
//     ["1",undefined],
//     ["",undefined],
//     [[1],undefined],
//     [{a:1},undefined],
//     [1,6],
//     [1.5,6.5],
//     [-1.5,3.5]
// ];
// const subTests=[
//     ["",undefined],
//     ["1",undefined],
//     [[1],undefined],
//     [{a:0},undefined],
//     [20,10],
//     [0,-10],
//     [-10.5,-20.5]
// ];
// const sumTests=[
//     [0,"1",undefined],
//     ["1",0,undefined],
//     ["",1,undefined],
//     [1,"",undefined],
//     [[1],0,undefined],
//     [{a:1},0,undefined],
//     [1,2,3],
//     [-1,1,0],
//     [-1,-1,-2],
//     [-1.5,-10,-11.5]
// ];
    // addTests.forEach(x=>it(`addFive to ${x[0]}=>${x[1]}`, function () {
    //     expect(mathEnforcer.addFive(x[0])).to.equal(x[1]);
    // }));
    // subTests.forEach(x=>it(`subtractTen from ${x[0]}=>${x[1]}`, function () {
    //     expect(mathEnforcer.subtractTen(x[0])).to.equal(x[1]);
    // }));
    // sumTests.forEach(x=>it(`sum ${x[0]} and ${x[1]}=>${x[2]}`, function () {
    //     expect(mathEnforcer.sum(x[0],x[1])).to.equal(x[2]);
    // }));
});
