//1.	Sort Array

function solve(arr, c) {
    const obj={
        asc:(a,b)=>a-b,
        desc:(a,b)=>b-a
    };
    return arr.sort(obj[c]);
}

console.log(solve([14, 7, 17, 6, 8], 'asc'));
console.log(solve([14, 7, 17, 6, 8], 'desc'));

//2.	Argument Info

function solve() {
    let argTypes=new Map();
    for (let argument of arguments) {
        let type=typeof (argument);
        if (!argTypes.has(type)) argTypes.set(type,0);
        argTypes.set(type,argTypes.get(type)+1);
        console.log(`${type}: ${argument}`)
    }
    [...argTypes].sort((a,b)=>b[1]-a[1]).forEach(a=>console.log(`${a[0]} = ${a[1]}`))
}

// solve('cat', 42, function () { console.log('Hello world!'); });
solve({ name: 'bob'}, 3.333, 9.999);

//3.	Personal BMI
function solve(name, age, weight, height) {
    // let name=arguments[0];
    // let age=+arguments[1];
    // let weight=+arguments[2];
    // let height=+arguments[3]/100;
    let personalInfo={age:age,weight:weight,height:height};
    let BMI=Math.round(weight/(height/100)**2);
    let patient={name:name,
        personalInfo:personalInfo,
        BMI: BMI,
        status: getStatus(BMI)
        // recommendation: undefined
    };
    if (getStatus(BMI)==='obese') patient['recommendation']='admission required';

    function getStatus(bmi){
        let status='';
        if (BMI>=30) status='obese';
        else if (BMI>=25) status='overweight';
        else if (BMI>=18.5) status='normal';
        else status='underweight';
        return status
    }
    // console.log(patient);
    return patient;
}
(solve('Honey Boo Boo', 9, 57, 137));

//- name, age, weight and height

//4.	Vector Math
let solution =(function () {
    function add(a,b) {
        return [a[0]+b[0], a[1]+b[1]];
    }
    function multiply(a, b) {
        return [a[0]*b, a[1]*b];
    }
    function length(a) {
        return Math.sqrt(a[0]**2+a[1]**2)
    }
    function dot(a,b) {
        return a[0]*b[0]+ a[1]*b[1]
    }
    function cross(a,b) {
        return a[0]*b[1]- a[1]*b[0]
    }

    return{
        add,
        multiply,
        length,
        dot,
        cross
    }
})();
// FOR JUDGE : (function () {....})();
// console.log(solution.add([1, 1], [1, 0]));
// console.log(solution.multiply([3.5, -2], 2));
// console.log(solution.length([3, -4]));
// console.log(solution.dot([1, 0], [0, -1]));
// console.log(solution.dot([2, 3], [2, -1]));
// console.log(solution.cross([3, 7], [1, 0]));

// 5.	Breakfast Robot
let manager = (()=>{
    let stock={
        protein:0,
        carbohydrates:0,
        fat:0,
        flavour:0
    };
    let recipes={
        apple:{protein:0,
            carbohydrates:1,
            fat:0,
            flavours:2},
        lemonade:{protein:0,
            carbohydrates:10,
            fat:0,
            flavours:20},
        burger:{protein:0,
            carbohydrates:5,
            fat:7,
            flavours:3},
        eggs:{protein:5,
            carbohydrates:0,
            fat:1,
            flavours:1},
        turkey:{protein:10,
            carbohydrates:10,
            fat:10,
            flavours:10},
    };
    function restock(microelement,quantity) {
        stock[microelement]+=Number(quantity);
        return "Success";
    }
    function isMissingIngredient(recipe, quantity) {
        let missing=0;
        // console.log(Object.keys(recipes[recipe]));
        for (let k of Object.keys(recipes[recipe])) {
            if (recipes[recipe][k]*+quantity<stock[k]) {
                missing=k;
                console.log(missing);
                break;
            }
        }
        return missing;
    }
    function prepare(recipe, quantity) {
        let missing=isMissingIngredient(recipe,quantity);
        if (missing){
            return `Error: not enough ${missing} in stock`;
        } else return "Success";
    }
    return command => {

        let tokens = command.split(' ');
        let action = tokens.shift();
        switch (action) {
            case "prepare":
                return prepare(...tokens);
                break;
            case "restock":
                return restock(...tokens);
                break;
            // case "report":
            //     return report();
        }
    }
})
();

//console.log(manager("restock flavour 50"));
//console.log(manager("prepare lemonade 4"));

// 6.	*Functional Sum
function add(input) {
    let sum = 0;

    solve.toString = function () {
        return sum;
    };

    function solve() {
        sum += parseInt(arguments[0]);
        return solve;
    }
    return solve(input);
}

// console.log(add(1)(6)(-3).toString());

