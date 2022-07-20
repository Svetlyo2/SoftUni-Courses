function solve() {
    let obj={
        list:[],
        add:function (element) {
            this.list.push(element);
            this.list.sort((a,b)=>a-b);
            this.size++;
        },
        remove:function (index) {
            if (index < 0 || this.size <= index) {
                throw new Error('Invalid index!');
            }
            this.list.splice(index,1);
            this.size--;
        },
        get:function (index) {
            return this.list[index]
        },
        size:0
    };
    return obj;
}
