
// 01. Fruit
function solve(f, w, p) {
    let money = w / 1000 * p;
    console.log(`I need $${money.toFixed(2)} to buy ${(w / 1000).toFixed(2)} kilograms ${f}.`)
}

// solve('orange', 2500, 1.80);

// 2. Greatest Common Divisor – GCD
function solve(a, b) {
    let result = a % b;
    while (result != 0) {
        a = b;
        b = result;
        result = a % b;
    }
    console.log(b);
}

// solve(15,6);
// // solve(2154, 458);

// 3. Same Numbers

function solve(n) {
    let nAsDigit = n + '';
    let result = (nAsDigit.split('').filter(d => d === nAsDigit[0]).length) === nAsDigit.length;
    let sum = nAsDigit.split('').reduce((a, b) => a + Number(b), 0);
    return result + '\n' + sum;
}

// console.log(solve(1234));

// 4. Time to Walk
function solve(s, f, speed) {
    let mPerSec = speed / 3.6;
    let meters = s * f;
    let seconds = Math.round(meters / mPerSec);
    seconds += Math.floor(meters / 500) * 60;
    let hours = Math.floor(seconds / 3600);
    let minutes = Math.floor(seconds % 3660 / 60);
    let resultSec = Math.ceil(seconds % 3660 % 60);
    let result = String(hours).padStart(2, '0') + ':';
    result += String(minutes).padStart(2, '0') + ':';
    result += String(resultSec).padStart(2, '0');

    return result
}

// console.log(solve(2564, 0.70, 5.5));

// 5. Calorie Object
function solve(arr) {
    let obj = {};
    for (let i = 0; i < arr.length; i += 2) {
        obj[arr[i]] = +arr[i + 1];
    }
    return obj;
}

// console.log(solve(['Potato', 93, 'Skyr', 63, 'Cucumber', 18, 'Milk', 42]));

// 6. Road Radar

function solve(arr) {
    let limits = {
        'motorway': 130,
        'interstate': 90,
        'city': 50,
        'residential': 20
    };
    let result='';
    let [speed, area] = arr;
    if (speed - limits[area] > 40) result = 'reckless driving';
    else if (speed - limits[area] > 20) result = 'excessive speeding';
    else if (speed - limits[area] > 0) result = 'speeding';
    return result;
}

// console.log(solve([200, 'motorway']));

// 7. Cooking by Numbers
function solve(arr) {
    let result=arr[0];
    for (let i = 1; i < arr.length; i++) {
        let operation=arr[i];
        switch (operation) {
            case 'chop': result/=2;
                console.log(result);
                break;
            case 'dice': result=Math.sqrt(result);console.log(result); break;
            case 'spice': result+=1;console.log(result); break;
            case 'bake': result*=3;console.log(result); break;
            case 'fillet': result*=0.8;console.log(result); break;
        }
    }
}
// solve(['9', 'dice', 'spice', 'chop', 'bake', 'fillet']);

// 8. Validity Checker
function solve([x1, y1, x2, y2]) {
    let dist1=Math.sqrt(x1**2+y1**2);
    let dist2=Math.sqrt(x2**2+y2**2);
    let dist=Math.sqrt((x1-x2)**2+(y1-y2)**2);
    dist1===parseInt(dist1)? console.log(`{${x1}, ${y1}} to {0, 0} is valid`):console.log(`{${x1}, ${y1}} to {0, 0} is invalid`);
    dist2===parseInt(dist2)? console.log(`{${x2}, ${y2}} to {0, 0} is valid`):console.log(`{${x2}, ${y2}} to {0, 0} is invalid`);
    dist===parseInt(dist)? console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is valid`):console.log(`{${x1}, ${y1}} to {${x2}, ${y2}} is invalid`);
}
// solve([2, 1, 1, 1]);

// 9.Coffee Machine
function solve(input) {
    let income=0;
    let result='';
    let prices={
        'coffee caffeine':0.8,
        'coffee decaf':0.9,
        'tea':0.8,
        'sugar':0.1
    };
    for (let line of input) {
        let order=line.split(', ');
        let coins=+order[0];
        let drink=order[1];
        let price;
        if (drink==='coffee') drink+=' '+order[2];
        price=prices[drink];
        if (order.includes('milk')) price=Math.round(price*1.1*10)/10;
        if (order[order.length-1]>0) price+=prices['sugar'];
        if (coins>=price){
            result+=`You ordered ${drink}. Price: $${(price).toFixed(2)} Change: $${(coins-price).toFixed(2)}\n`
            income+=price;
        } else result+=`Not enough money for ${drink}. Need $${(price-coins).toFixed(2)} more\n`;
    }
    result+=`Income Report: $${(income).toFixed(2)}`;
    return result;
}

// console.log(solve(['8.00, coffee, decaf, 4', '1.00, tea, 2']));

