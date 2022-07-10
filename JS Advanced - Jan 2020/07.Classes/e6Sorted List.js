class List {
    constructor() {
        this.list = [];
        this.size=0;
    }
    add(element){
        this.list.push(element);
        this.list.sort((a,b)=>a-b);
        this.size++
    }
    remove(index){
        if (index>=0 && index<this.size){
            delete this.list[index];
            this.list.sort((a,b)=>a-b);
            this.size--;
        }
    }
    get(index){
        return this.list[index]
    }
}
//test
let list = new List();
list.add(5);
list.add(6);
list.add(7);
console.log(list.get(1));
list.remove(1);
console.log(list.get(1));
console.log(list.size);
