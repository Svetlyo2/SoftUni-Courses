function solve() {
    let myObj={
        extend:function (template) {
            Object.keys(template).forEach(k=>{
                if (typeof template[k]==='function') {
                    Object.prototype[k]=template[k]
                    // Object.getPrototypeOf(this)[k]=template[k]
                } else {
                    this[k]=template[k]
                }
            });
        }
    };
    //for test
    // myObj.extend({
    //     someKey:123,
    //     extensionMethod: function () {
    //         console.log('cloned')
    //     },
    //     extensionProperty: 'someString'
    // });
    // console.log(myObj['someKey']);
    return myObj;
}

solve();