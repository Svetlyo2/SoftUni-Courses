let expect=require('chai').expect;

function lookupChar(string, index) {
    if (typeof(string) !== 'string' || !Number.isInteger(index)) {
        return undefined;
    }
    if (string.length <= index || index < 0) {
        return "Incorrect index";
    }

    return string.charAt(index);
}
describe('Odd or even length tests',function(){
    it('non-string,1=>undefined', function () {
        expect(lookupChar(12,1)).to.equal(undefined);
    });
    it('non-string,1=>undefined', function () {
        expect(lookupChar(['akljn'],1)).to.equal(undefined);
    });
    it('{},1=>undefined', function () {
        expect(lookupChar({a:'akljn'},1)).to.equal(undefined);
    });
    it('string,not number=>undefined', function () {
        expect(lookupChar('12','1')).to.equal(undefined);
    });
    it('string,[]=>undefined', function () {
        expect(lookupChar('12',[1])).to.equal(undefined);
    });
    it('string,float=>undefined', function () {
        expect(lookupChar('hibnini',1.5)).to.equal(undefined);
    });
    // for Error
    it('string,negative number=>error', function () {
        expect(lookupChar('koko',-1)).to.equal('Incorrect index')
    });
    it('string,negative number=>error', function () {
        // expect(()=>new lookupChar('koko',-1)).to.Throw("Incorrect index")
        expect(()=>lookupChar('koko',-1)).to.throw("Incorrect index");
    });

    it('string, index>length =>error', function () {
        expect(lookupChar('koko',5)).to.equal('Incorrect index')
    });
    it('correct input =>char', function () {
        expect(lookupChar('koko',0)).to.equal('k')
    });
    it('correct input =>char', function () {
        expect(lookupChar('koko',3)).to.equal('o')
    });

});
