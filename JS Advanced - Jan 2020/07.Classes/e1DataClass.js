class Request {

    constructor(method, uri, version, message, response=undefined, fulfilled=false) {
        this.method = method;
        this.uri = uri;
        this.version = version;
        this.message = message;
        this.response = response;
        this.fulfilled = fulfilled;
    }
}
class Request2 {

    constructor(method, uri, version, message) {
        this.method = method;
        this.uri = uri;
        this.version = version;
        this.message = message;
        this.response = undefined;
        this.fulfilled = false;
    }
}
//test
let myData = new Request2('GET', 'http://google.com', 'HTTP/1.1', '')
console.log(myData);