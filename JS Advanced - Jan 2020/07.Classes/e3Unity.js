class Rat {
    constructor(name) {
        this.name = name;
        this.unitedRats=[];
    }
    unite(otherRat){
        if (otherRat instanceof Rat)
        this.unitedRats.push(otherRat)
    }
    getRats(){
        return this.unitedRats;
    }
    toString(){
        return `${this.name}\n${(this.unitedRats).map(k=>'##'+k).join('').trim()}`
    }
}
//test
let firstRat = new Rat("Peter");
// console.log(firstRat.toString()); // Peter
//
// console.log(firstRat.getRats()); // []
//
firstRat.unite(new Rat("George"));
firstRat.unite(new Rat("Alex"));
// console.log(firstRat.getRats());
// [ Rat { name: 'George', unitedRats: [] },
//  Rat { name: 'Alex', unitedRats: [] } ]

console.log(firstRat.toString());
// Peter
// ##George
// ##Alex
