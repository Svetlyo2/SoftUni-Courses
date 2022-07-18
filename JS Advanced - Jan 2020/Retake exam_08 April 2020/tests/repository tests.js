let expect = require('chai').expect;

class Repository {
    constructor(props) {
        this.props = props;
        this.data = new Map();

        let id = 0;
        this.nextId = function () {
            return id++;
        }
    }

    get count() {
        return this.data.size;
    }

    add(entity) {
        this._validate(entity);
        let id = this.nextId();
        this.data.set(id, entity);
        return id;
    }

    getId(id) {
        if (!this.data.has(id)) {
            throw new Error(`Entity with id: ${id} does not exist!`);
        }

        return this.data.get(id);
    }

    update(id, newEntity) {
        if (!this.data.has(id)) {
            throw new Error(`Entity with id: ${id} does not exist!`);
        }

        this._validate(newEntity);
        this.data.set(id, newEntity);
    }

    del(id) {
        if (!this.data.has(id)) {
            throw new Error(`Entity with id: ${id} does not exist!`);
        }

        this.data.delete(id);
    }

    _validate(entity) {
        //Validate existing property
        for (let propName in this.props) {
            if (!entity.hasOwnProperty(propName)) {
                throw new Error(`Property ${propName} is missing from the entity!`);
            }
        }

        //Validate property type
        for (let propName in entity) {
            let val = entity[propName];
            if (typeof val !== this.props[propName]) {
                throw new TypeError(`Property ${propName} is not of correct type!`);
            }
        }
    }
}

describe('Repository tests', function () {
    let actualResult;
    let rep;

    beforeEach(function () {
        let properties = {
            name: "string",
            age: "number",
            birthday: "object"
        };
        let entity = {
            name: "Pesho",
            age: 22,
            birthday: new Date(1998, 0, 7)
        };

        rep = new Repository(properties);
        actualResult=null;
    });


    describe('constructor tests', function () {
        it('Test Properties', () => {
            expect(rep.props).to.deep.equal({
                name: "string",
                age: "number",
                birthday: "object"
            });
            expect(rep.data).to.deep.equal(new Map());
            expect(rep.data).to.be.an.instanceof(Map);
        });
    });
    describe('get count tests', function () {
        it(`0 entities=>0`, function () {
            expect(rep.count).to.equal(0);
        });

        it(`1 entities=>1`, function () {
            let entity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };
            actualResult=rep.add(entity);
            expect(rep.count).to.equal(1);
        });
    });
    describe('add tests', function () {
        it(`1 entities=>1`, function () {
            let entity = {
                name: "Pesho",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };
            actualResult=rep.add(entity);
            expect(actualResult).to.equal(0);
            expect(rep.data).to.hasOwnProperty('0');
            actualResult=rep.add(entity);
            expect(actualResult).to.equal(1)
        });
        it(`w/o name ''=>error`, function () {
            let entity = {
                age: 22,
                birthday: new Date(1998, 0, 7)
            };
            actualResult=()=>rep.add(entity);
            expect(actualResult).to.throw(`Property name is missing from the entity!`);
        });
        it(`name ''=>error`, function () {
            let entity = {
                name: 5,
                age: 22,
                birthday: new Date(1998, 0, 7)
            };
            actualResult=()=>rep.add(entity);
            expect(actualResult).to.throw(`Property name is not of correct type!`);
        });
        it(`w/o age ''=>error`, function () {
            let entity = {
                name: "Pesho",
                birthday: new Date(1998, 0, 7)
            };
            actualResult=()=>rep.add(entity);
            expect(actualResult).to.throw(`Property age is missing from the entity!`);
        });
        it(` age ''=>error`, function () {
            let entity = {
                name: "Pesho",
                age: 'ten',
                birthday: new Date(1998, 0, 7)
            };
            actualResult=()=>rep.add(entity);
            expect(actualResult).to.throw(`Property age is not of correct type!`);
        });
        it(`w/o birthday ''=>error`, function () {
            let entity = {
                name: "Pesho",
                age: 22
            };
            actualResult=()=>rep.add(entity);
            expect(actualResult).to.throw(`Property birthday is missing from the entity!`);
        });
        it(`w/o birthday ''=>error`, function () {
            let entity = {
                name: "Pesho",
                age: 22,
                birthday: ''
            };
            actualResult=()=>rep.add(entity);
            expect(actualResult).to.throw(`Property birthday is not of correct type!`);
        });
    });
    describe('getId tests', function () {
        let entity = {
            name: "Pesho",
            age: 22,
            birthday: new Date(1998, 0, 7)
        };
        it(`with name=>message`, function () {
            rep.add(entity);
            expect(rep.getId(0)).to.deep.equal({"age": 22,
                "birthday": new Date(1998, 0, 7),
            "name": "Pesho"});
        });

        it(`missing id=>error`, function () {
            rep.add(entity);
            actualResult=()=>rep.getId(2);
            expect(actualResult).to.throw(`Entity with id: 2 does not exist!`);
        });
    });

    describe('update tests', function () {
        let entity = {
            name: "Pesho",
            age: 22,
            birthday: new Date(1998, 0, 7)
        };
        it(`with name=>message`, function () {
            rep.add(entity);
            let entity2 = {
                name: "Mara",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };
            rep.update(0,entity2);
            expect(rep.getId(0)).to.deep.equal({"age": 22,
                "birthday": new Date(1998, 0, 7),
                "name": "Mara"});
        });

        it(`missing id=>error`, function () {
            rep.add(entity);
            actualResult=()=>rep.update(2);
            expect(actualResult).to.throw(`Entity with id: 2 does not exist!`);
        });
    });

    describe('del tests', function () {
        let entity = {
            name: "Pesho",
            age: 22,
            birthday: new Date(1998, 0, 7)
        };
        it(`id=>deleted`, function () {
            rep.add(entity);
            let entity2 = {
                name: "Mara",
                age: 22,
                birthday: new Date(1998, 0, 7)
            };
            rep.add(entity2);
            rep.del(0);
            actualResult=()=>rep.getId(0);
            expect(actualResult).to.throw(`Entity with id: 0 does not exist!`);
        });

        it(`missing id=>error`, function () {
            rep.add(entity);
            actualResult=()=>rep.del(2);
            expect(actualResult).to.throw(`Entity with id: 2 does not exist!`);
        });
    });
});


// module.exports = { Repository };

// Initialize props object
// let properties = {
//     name: "string",
//     age: "number",
//     birthday: "object"
// };
// //Initialize the repository
// let repository = new Repository(properties);
// // Add two entities
// let entity = {
//     name: "Pesho",
//     age: 22,
//     birthday: new Date(1998, 0, 7)
// };
// repository.add(entity); // Returns 0
// repository.add(entity); // Returns 1
// console.log(repository.getId(0));
// // {"name":"Pesho","age":22,"birthday":"1998-01-06T22:00:00.000Z"}
// console.log(repository.getId(1));
// // {"name":"Pesho","age":22,"birthday":"1998-01-06T22:00:00.000Z"}
// //Update an entity
// entity = {
//     name: 'Gosho',
//     age: 22,
//     birthday: new Date(1998, 0, 7)
// };
// repository.update(1, entity);
// console.log(repository.getId(1));
// // {"name":"Gosho","age":22,"birthday":"1998-01-06T22:00:00.000Z"}
// // Delete an entity
// repository.del(0);
// console.log(repository.count); // Returns 1
// let anotherEntity = {
//     name1: 'Stamat',
//     age: 29,
//     birthday: new Date(1991, 0, 21)
// };
// // repository.add(anotherEntity); // should throw an Error
// anotherEntity = {
//     name: 'Stamat',
//     age: 29,
//     birthday: 1991
// };
// repository.add(anotherEntity); // should throw a TypeError
// repository.del(-1); // should throw Error for invalid id