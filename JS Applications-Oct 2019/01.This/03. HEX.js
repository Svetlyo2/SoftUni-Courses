class Hex {
    value;
    constructor(value) {
        this.value = value;
    }
    valueOf(){
        return this.value;
    }

    toString(){
        return `0x${this.value.toString(16).toUpperCase()}`;
    }
    plus(number){
        return new Hex(this.value+number)
    }
    minus(number){
        return new Hex(this.value-number)
    }
    parse(hexString){
        return parseInt(hexString,16);
    }
}

let FF = new Hex(255);
console.log(FF.toString());
console.log((FF.valueOf()+1));
let a = new Hex(10);
let b = new Hex(5);
console.log(a.plus(b).toString());
console.log(a.plus(b).toString()==='0xF');
console.log(FF.parse('0xF'));