// 1. Multiply Numbers
function solve(a,b) {
    return a*b;
}
// console.log(solve(23632.36, -12.3249));
// 2. Boxes and Bottles
function solve(bottles,capacity) {
    console.log(Math.ceil(bottles/capacity));
}
// solve(15,7);
// 3. Leap Year
function solve(year) {
    let isLeap=(year%4===0 && year%100!==0)||year%400===0;
    console.log(isLeap?'yes':'no')
}
// solve(1900);
// 4. Circle Area
function solve(radius) {
    let area=Math.PI*radius**2;
    console.log(area);
    console.log(area.toFixed(2));
}
// solve(5);
// 5. Triangle Area
function solve(a,b,c) {
    let area=Math.sqrt((a+b+c)*(-a+b+c)*(a-b+c)*(a+b-c))/4;
    console.log(area);
}
// solve(2, 3.5, 4);
// 6. Cone
function solve(radius,height,) {
    let volume=(Math.PI*height*radius**2)/3;
    let area=Math.PI*radius*(Math.sqrt(radius**2+height**2))+Math.PI*radius**2;
    console.log(`volume = ${volume}`);
    console.log(`area = ${area}`);
}
// solve(3,5);
// 7. Odd / Even
function solve(n) {
    if (!Number.isInteger(n))
        console.log('invalid')
    else {
    let isOdd=n%2;
    console.log(isOdd?'odd':'even');
    }
}
// solve(1.5);
// 8. Fruit or Vegetable
function solve(input) {
    switch (input) {
        case 'banana':
        case 'apple':
        case 'kiwi':
        case 'cherry':
        case 'lemon':
        case 'grapes':
        case 'peach':
            console.log('fruit');
            break;
        case 'tomato':
        case 'cucumber':
        case 'pepper':
        case 'onion':
        case 'garlic':
        case 'parsley':
            console.log('vegetable');
            break;
        default:
            console.log('unknown');
            break;
    }
}
// solve('pizza');
// 9. Colorful Numbers
function solve(n) {
    let html='<ul>\n';
    for (let i = 1; i <= n; i++) {
        html+='\t<li><span style=\'color:';
        if (i%2===0) html+='blue';
        else html+='green';
        html+=`\'>${i}</span></li>\n`
    }
    html+='</ul>';
    console.log(html);
}

// solve(5);
// 10. Chessboard
function solve(n) {
    let color='';
    let html='<div class="chessboard">';
    for (let row = 1; row <=n ; row++) {
        html+='\n\t<div>';
        color=(row%2===0) ? 'black':'white';
        for (let col = 1; col <= n; col++) {
            color=(color==='white') ? 'black':'white';
            html+=`\n\t\t<span class="${color}"></span>`;
        }
        html+='\n\t</div>';
    }
    html+='\n</div>';
    console.log(html);
}
// solve(3);
// 11. Binary Logarithm
function solve(arr) {
    for (const n of arr) {
        console.log(Math.log2(n));
    }
}
// solve([1024, 1048576, 256, 1, 2]);
// 12. Prime Number Checker
function solve(n) {
    let isPrime=true;
    for (let i = 2; i <=Math.sqrt(n) ; i++) {
        if (n%i===0) {
            isPrime=false;
            break;
        }
    }
    return isPrime&&n>1;
}

// console.log(solve(-7));
// 1. Biggest of 3 Numbers
function solve(nums) {
return Math.max(nums[0],nums[1],nums[2])
}

// console.log(solve([5, -2, 7]));
// 2. Point in Rectangle
function solve([x, y, xMin, xMax, yMin, yMax]) {
    return (xMin<=x && x<=xMax && yMin<=y && y<=yMax)
        ? 'inside': 'outside';
}

// console.log(solve([8,
// //     -1,
// //     2,
// //     12,
// //     -3,
// //     3]));
// // 3. Odd Numbers 1 to N
function solve(n) {
    for (let i = 1; i <= n; i++) {
        if (i%2!==0) console.log(i);
    }
}
// solve(7);
// 4. Triangle of Dollars
function solve(n) {
    for (let i = 1; i <= n; i++) {
        console.log('$'.repeat(i));
    }
}
// solve(3);
// 5. Movie Prices
function solve([movieTitle, weekday]) {
    let result;
    let title=movieTitle.toLowerCase();
    let day=weekday.toLowerCase();
    if (title==='The Godfather'.toLowerCase()){
        switch (day) {
            case 'monday': result=12; break;
            case 'tuesday': result=10; break;
            case 'wednesday': result=15; break;
            case 'thursday': result=12.5; break;
            case 'friday': result=15; break;
            case 'saturday': result=25; break;
            case 'sunday': result=30; break;
            default: result='error';
        }
    } else if (title==='Schindler\'s List'.toLowerCase()){
        switch (day) {
            case 'monday': result=8.5; break;
            case 'tuesday': result=85; break;
            case 'wednesday': result=8.5; break;
            case 'thursday': result=8.5; break;
            case 'friday': result=8.5; break;
            case 'saturday': result=15; break;
            case 'sunday': result=15; break;
            default: result='error';
        }
    } else if (title==='Casablanca'.toLowerCase()){
        switch (day) {
            case 'monday': result=8; break;
            case 'tuesday': result=8; break;
            case 'wednesday': result=8; break;
            case 'thursday': result=8; break;
            case 'friday': result=8; break;
            case 'saturday': result=10; break;
            case 'sunday': result=10; break;
            default: result='error';
        }
    } else if (title==='The Wizard of Oz'.toLowerCase()){
        switch (day) {
            case 'monday': result=10; break;
            case 'tuesday': result=10; break;
            case 'wednesday': result=10; break;
            case 'thursday': result=10; break;
            case 'friday': result=10; break;
            case 'saturday': result=15; break;
            case 'sunday': result=15; break;
            default: result='error';
        }
    } else result='error';
    return result;
}
// console.log(solve(['The Godfather',
//     'Friday']));
// 6. Quadratic Equation
function solve(a,b,c) {
    let discriminant=b**2-4*a*c;
    if (discriminant>=0){
        let x1=(-b+Math.sqrt(discriminant))/(2*a);
        let x2=(-b-Math.sqrt(discriminant))/(2*a);
        if (x1<x2) {
            console.log(`${x1}\n${x2}`);
        } else if (x1>x2) {console.log(`${x2}\n${x1}`)}
        else console.log(x1);
    } else console.log('No')
}
// solve(1, -12, 36);
// 7. Multiplication Table
function solve(n) {
    let html='<table border="1">\n';
    for (let row = 0; row <= n; row++) {
        html+='<tr><th>';
        row===0?html+='x</th>':html+=`${row}</th>`;
        for (let col = 1; col <=n ; col++) {
            let n=row*col;
            if (row>0) html+=`<td>${n}</td>`;
            else html+=`<th>${col}</th>`;
        }
        html+='</tr>\n';
    }
    return html+='</table>';
}
// console.log(solve(5));
// 8. Figure of 4 Squares
function solve(n) {
    let rows=(n%2===0)?n-1:n;
    let inner=(2*n-1-3)/2;
    for (let row = 0; row < rows; row++) {
        if (row===0||row===rows-1||row===Math.ceil(rows/2-1)){
            console.log('+'+'-'.repeat(inner)+'+'+'-'.repeat(inner)+'+')
        } else console.log('|'+' '.repeat(inner)+'|'+' '.repeat(inner)+'|');
    }
}
// solve(4);
// 9. Monthly Calendar

