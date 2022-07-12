let expect = require("chai").expect

function isOddOrEven(string) {
    if (typeof(string) !== 'string') {
        return undefined;
    }
    if (string.length % 2 === 0) {
        return "even";
    }

    return "odd";
}
describe('Odd or even length tests',function(){
    it('non-string=>undefined', function () {
            expect(isOddOrEven(1)).to.equal(undefined);
        });
    it(' ""=>undefined', function () {
        expect(isOddOrEven()).to.equal(undefined);
    });
    it('[]=>undefined', function () {
        expect(isOddOrEven([1])).to.equal(undefined);
    });
    it('{}=>undefined', function () {
        expect(isOddOrEven({})).to.equal(undefined);
    });
    it(' "aa"=>undefined', function () {
        expect(isOddOrEven("aa")).to.equal("even");
    });
    it(' "a"=>undefined', function () {
        expect(isOddOrEven("a")).to.equal("odd");
    });

});
