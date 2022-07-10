class CheckingAccount {
    constructor(clientId, email, firstName, lastName) {
        this.clientId = clientId;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    get clientId() {
        return this._clientId;
    }

    set clientId(value) {
        let pattern=/^\d{6}$/;
        // let match=pattern.test(value);
        if (value.match(pattern)) this._clientId = value;
        else throw new TypeError('Client ID must be a 6-digit number');
    }

    get email() {
        return this._email;
    }

    set email(value) {
        let pattern=/^[a-z0-9]+@[a-z\\.]+$/gmi;
        let match=value.match(pattern);
        if (match) this._email = value;
        else throw new TypeError('Invalid e-mail');

    }

    get firstName() {
        return this._firstName;
    }
    isValidName(n){
        let pattern=/^[a-z]{3,20}$/gmi;
        return n.match(pattern);
    }

    set firstName(value) {
        if (value.length<3 || value.length>20) throw new TypeError('First name must be between 3 and 20 characters long');
        if (this.isValidName(value)) this._firstName = value;
        else throw new TypeError('First name must contain only Latin characters');
    }

    get lastName() {
        return this._lastName;
    }

    set lastName(value) {
        if (value.length<3 || value.length>20) throw new TypeError('Last name must be between 3 and 20 characters long');

        if (this.isValidName(value))  this._lastName = value;
        else throw new TypeError('Last name must contain only Latin characters');
    }
}
let acc = new CheckingAccount("477865", 'ivan@ivan', 'Ivan', 'Pet4');
console.log(acc);