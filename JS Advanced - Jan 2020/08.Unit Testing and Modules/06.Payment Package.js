let expect = require('chai').expect;
let assert = require('chai').assert;


class PaymentPackage {
    constructor(name, value) {
        this.name = name;
        this.value = value;
        this.VAT = 20;      // Default value
        this.active = true; // Default value
    }

    get name() {
        return this._name;
    }

    set name(newValue) {
        if (typeof newValue !== 'string') {
            throw new Error('Name must be a non-empty string');
        }
        if (newValue.length === 0) {
            throw new Error('Name must be a non-empty string');
        }
        this._name = newValue;
    }

    get value() {
        return this._value;
    }

    set value(newValue) {
        if (typeof newValue !== 'number') {
            throw new Error('Value must be a non-negative number');
        }
        if (newValue < 0) {
            throw new Error('Value must be a non-negative number');
        }
        this._value = newValue;
    }

    get VAT() {
        return this._VAT;
    }

    set VAT(newValue) {
        if (typeof newValue !== 'number') {
            throw new Error('VAT must be a non-negative number');
        }
        if (newValue < 0) {
            throw new Error('VAT must be a non-negative number');
        }
        this._VAT = newValue;
    }

    get active() {
        return this._active;
    }

    set active(newValue) {
        if (typeof newValue !== 'boolean') {
            throw new Error('Active status must be a boolean');
        }
        this._active = newValue;
    }

    toString() {
        const output = [
            `Package: ${this.name}` + (this.active === false ? ' (inactive)' : ''),
            `- Value (excl. VAT): ${this.value}`,
            `- Value (VAT ${this.VAT}%): ${this.value * (1 + this.VAT / 100)}`
        ];
        return output.join('\n');
    }
}

describe('Payment Package tests', function () {
    let pp;

    beforeEach(()=>{
        pp = new PaymentPackage('Consultation', 800);
    });
    describe('instantiate', function () {
        it('string,num=>class', function () {
            expect(pp).to.haveOwnProperty('_name').equal('Consultation');
            expect(pp).to.haveOwnProperty('_value').equal(800);
            expect(pp).to.haveOwnProperty('_VAT').equal(20);
            expect(pp).to.haveOwnProperty('_active').equal(true);
        });
    });
    describe('test name',function () {
        it('non-string=>Error', function () {
            pp=()=>new PaymentPackage(10,800);
            expect(pp).to.throw('Name must be a non-empty string');
        });
        it('""=>Error', function () {
            pp=()=>new PaymentPackage('',800);
            expect(pp).to.throw('Name must be a non-empty string');
        });
        // it('name=>name', function () {
        //     expect(pp.name).to.equal('Consultation');
        // });
        it('set name', function () {
            expect(pp.name='newName').to.equal('newName');
        });
    });
    describe('test value', function () {
        it('non-num value=>Error', function () {
            pp=()=>new PaymentPackage('consult','big');
            expect(pp).to.throw('Value must be a non-negative number');
        });
        it('negative value=>Error', function () {
            pp=()=>new PaymentPackage('consult',-800);
            expect(pp).to.throw('Value must be a non-negative number');
        });
        // it('value', function () {
        //     expect(pp.value).to.equal(800);
        // });

        it('set value', function () {
            expect(pp.value=10).to.equal(10);
        });
    });

    describe('test VAT', function () {
        it('default 20', function () {
            expect(pp.VAT).to.equal(20);
        });
        it('set VAT', function () {
            expect(pp.VAT=10).to.equal(10);
        });
        it('string=>Error', function () {
            let check=()=>pp.VAT='no';
            expect(check).to.throw('VAT must be a non-negative number');
        });
        it('negative=>Error', function () {
            let check=()=>pp.VAT=-10;
            expect(check).to.throw('VAT must be a non-negative number');
        });
    });
    describe('test active', function () {
        it('default true', function () {
            expect(pp.active).to.equal(true);
        });
        it('set VAT', function () {
            expect(pp.active=false).to.equal(false);
        });
        it('num=>Error', function () {
            let check=()=>pp.active=10;
            expect(check).to.throw('Active status must be a boolean');
        });
        it('string=>Error', function () {
            let check=()=>pp.active='no';
            expect(check).to.throw('Active status must be a boolean');
        });
    });
    describe('test toString', function () {
        it('when active', function () {
            expect(pp.toString()).to.equal('Package: Consultation\n- Value (excl. VAT): 800\n- Value (VAT 20%): 960');
        });
        it('when not active', function () {
            pp.active=false;
            expect(pp.toString()).to.equal('Package: Consultation (inactive)\n- Value (excl. VAT): 800\n- Value (VAT 20%): 960');
        });
        it('when value=0', function () {
            pp=new PaymentPackage('Consultation', 0);
            expect(pp.toString()).to.equal('Package: Consultation\n- Value (excl. VAT): 0\n- Value (VAT 20%): 0');
        });
        it('when VAT=0', function () {
            pp.VAT=0;
            expect(pp.toString()).to.equal('Package: Consultation\n- Value (excl. VAT): 800\n- Value (VAT 0%): 800');
        });
        it('when value and VAT=0', function () {
            pp=new PaymentPackage('Consultation', 0);
            pp.VAT=0;
            expect(pp.toString()).to.equal('Package: Consultation\n- Value (excl. VAT): 0\n- Value (VAT 0%): 0');
        });
    })
});

