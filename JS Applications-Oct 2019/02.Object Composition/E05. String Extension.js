(function solve() {
    String.prototype.ensureStart=function (str) {
        if (!this.startsWith(str)) return str.concat(this);
        return `${this}`;
    };
    String.prototype.ensureEnd=function (str) {
        if (!this.endsWith(str)) return this.concat(str);
        return `${this}`;
    };
    String.prototype.isEmpty=function () {
        return this.toString()===''
    };
    String.prototype.truncate=function(n){
        if (n<4) return '.'.repeat(n);
        else if (this.length<=n) return this.toString();
        else {
            let lastSpace = this.substr(0, n - 2).lastIndexOf(' ');
            if (lastSpace !== -1) {
                return this.substr(0, lastSpace).concat('...');
            }
            else {
                return this.substr(0, n - 3).concat('...');
            }
        }
    };
    String.format=function(string, ...params) {
        for (let i = 0; i < params.length; i++) {
            string = string.replace(`{${i}}`, params[i])
        }
        return string
    }

// for test
//     let str = 'my string';
//     console.log(str.ensureStart('my'));
//     str = str.ensureStart('hello ');
//     console.log(str)
//     console.log(str.truncate(16));
//     console.log(str.truncate(14));
//     console.log(str.truncate(8));
//     console.log(str.truncate(4));
//     console.log(str.truncate(2));
//     console.log(String.format('The {0} {1} fox',
//         'quick', 'brown'));
//     console.log(String.format('jumps {0} {1}',
//         'dog'));
})();

