let expect = require('chai').expect;
let assert = require('chai').assert;

class StringBuilder {
    constructor(string) {
        if (string !== undefined) {
            StringBuilder._vrfyParam(string);
            this._stringArray = Array.from(string);
        } else {
            this._stringArray = [];
        }
    }

    append(string) {
        StringBuilder._vrfyParam(string);
        for(let i = 0; i < string.length; i++) {
            this._stringArray.push(string[i]);
        }
    }

    prepend(string) {
        StringBuilder._vrfyParam(string);
        for(let i = string.length - 1; i >= 0; i--) {
            this._stringArray.unshift(string[i]);
        }
    }

    insertAt(string, startIndex) {
        StringBuilder._vrfyParam(string);
        this._stringArray.splice(startIndex, 0, ...string);
    }

    remove(startIndex, length) {
        this._stringArray.splice(startIndex, length);
    }

    static _vrfyParam(param) {
        if (typeof param !== 'string') throw new TypeError('Argument must be string');
    }

    toString() {
        return this._stringArray.join('');
    }
}



describe('StringBuilder tests', function () {
    let actualResult;
    let expectedResult;
    let sb;

    beforeEach(()=>{
        sb = new StringBuilder('');
        actualResult=null;
        expectedResult=null;
    });
    describe('instantiated tests', function () {
        it('with string=>class', function () {
            expect(new StringBuilder('hello')).to.be.an.instanceOf(StringBuilder);
        });
        it('with string abc', function () {
            actualResult=new StringBuilder('abc');
            expect(actualResult._stringArray).to.deep.equal(['a','b','c']);
        });
        it('with string abc', function () {
            actualResult=new StringBuilder('abc');
            expect(actualResult).to.have.property('_stringArray').with.lengthOf(3);
        });
        it('without string', function () {
            actualResult=new StringBuilder('');
            expect(actualResult._stringArray).to.deep.equal([]);
        });
        it('with non-string bool', function () {
            actualResult=()=>new StringBuilder(false);
            expect(actualResult).to.throw('Argument must be string')
        });
        it('with non-string num', function () {
            actualResult=()=>new StringBuilder(44);
            expect(actualResult).to.throw('Argument must be string')
        });

    });

    describe('append tests', function () {
        it('with string', function () {
            sb.append('ab');
            sb.append('cd');
            expect(sb._stringArray).deep.equal(['a','b','c','d']);
        });
        it('with non-string bool', function () {
            actualResult=()=>sb.append(false);
            expect(actualResult).to.throw('Argument must be string')
        });
    });
    describe('prepend tests', function () {
        it('with string', function () {
            sb.prepend('ab');
            sb.prepend('cd');
            expect(sb._stringArray).deep.equal(['c','d','a','b']);
        });
        it('with non-string bool', function () {
            actualResult=()=>sb.prepend(false);
            expect(actualResult).to.throw('Argument must be string')
        });
    });
    describe('insertAt tests', function () {
        it('with string,num', function () {
            sb=new StringBuilder('1234');
            sb.insertAt('xy',2);
            expect(sb._stringArray).deep.equal(['1','2','x','y','3','4']);
        });
        it('string spread', function () {
            sb=new StringBuilder('1234');
            let newString='abcd';
            sb.insertAt(newString,2);
            let inserted=sb._stringArray.slice(2,newString.length+2);
            expect(inserted).to.be.deep.equal(Array.from(newString));
        });
        it('insert in empty', function () {
            let newString='abcd';
            sb.insertAt(newString,2);
            expect(sb._stringArray).to.be.deep.equal(Array.from(newString));
        });
        it('with non-string-num ', function () {
            sb=new StringBuilder('1234');
            actualResult=()=>sb.insertAt(99,2);
            expect(actualResult).to.throw('Argument must be string')
        });
    });
    describe('remove tests', function () {
        it('with string,num', function () {
            sb=new StringBuilder('12345');
            sb.remove(2,2);
            expect(sb._stringArray).deep.equal(['1','2','5']);
        });
    });
    describe('toString tests', function () {
        it('with []', function () {
            expect(sb.toString()).to.equal('');
        });
        it(`with ['1','2','3']=>123`, function () {
            sb=new StringBuilder('123');
            expect(sb.toString()).to.equal('123');
        });
        it('should have the correct function properties', function () {
            assert.isFunction(StringBuilder.prototype.append);
            assert.isFunction(StringBuilder.prototype.prepend);
            assert.isFunction(StringBuilder.prototype.insertAt);
            assert.isFunction(StringBuilder.prototype.remove);
            assert.isFunction(StringBuilder.prototype.toString);
        });
        it('full test', function () {
            sb = new StringBuilder('hello');
            sb.append(', there');
            sb.prepend('User, ');
            sb.insertAt('woop', 5);
            sb.remove(6, 3);
            expect(sb.toString()).to.equal('User,w hello, there');
        });
    });

});
