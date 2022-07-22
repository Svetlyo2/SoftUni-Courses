function solve() {

    class Melon {
        constructor(weight, melonSort) {
            if (new.target===Melon) {throw new Error('Abstract class cannot be instantiated directly')}
            this.weight = weight;
            this.melonSort = melonSort;
            this.element='Melon';
        }
        get elementIndex () {return this.weight*this.melonSort.length}
        toString(){
            return `Element: ${this.element}\nSort: ${this.melonSort}`;
        }
    }
    class Watermelon extends Melon{
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = 'Water';
        }

        toString() {
            return super.toString()+`\nElement Index: ${this.elementIndex}`
        }
    }
    class Firemelon extends Melon{
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = 'Fire';
        }

        toString() {
            return super.toString()+`\nElement Index: ${this.elementIndex}`
        }
    }
    class Earthmelon extends Melon{
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = 'Earth';
        }

        toString() {
            return super.toString()+`\nElement Index: ${this.elementIndex}`
        }
    }
    class Airmelon extends Melon{
        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element = 'Air';
        }

        toString() {
            return super.toString()+`\nElement Index: ${this.elementIndex}`
        }
    }
    class Melolemonmelon extends Airmelon{

        constructor(weight, melonSort) {
            super(weight, melonSort);
            this.element='Water';
            this.elements=[ 'Fire', 'Earth', 'Air','Water']
        }

        morph(){
            this.element = this.elements.shift();
            this.elements.push(this.element);
        }
    }
    return {Melon,Watermelon,Earthmelon,Airmelon,Firemelon,Melolemonmelon}
}

// let test = new Melon(100, "Test");
//Throws error

let watermelon = new Watermelon(12.5, "Kingsize");
console.log(watermelon.toString());

// Element: Water
// Sort: Kingsize
// Element Index: 100






