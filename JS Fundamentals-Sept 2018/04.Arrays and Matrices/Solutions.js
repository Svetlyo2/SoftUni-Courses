
// 1. Print Array with Given Delimiter
function solve(arr) {
    let delimiter=arr.pop();
    console.log(arr.join(delimiter));
}
// solve(['One',
//     'Two',
//     'Three',
//     'Four',
//     'Five',
//     '-']
// );

// 2. Print every N-th Element from an Array

function solve(arr) {
    let step=parseInt(arr.pop());
    for (let i = 0; i < arr.length; i+=step) {
        console.log(arr[i]);
    }
}
// solve(['1',
//     '2',
//     '3',
//     '4',
//     '5',
//     '6']
// );

// 3. Add and Remove Elements
function solve(arr) {
    let result=[];
    let current=1;
    for (const command of arr) {
        if (command==='add'){
            result.push(current);
        } else {result.pop()}
        current++;
    }
    if (result.length===0){
        console.log('Empty')
    } else result.forEach(n=>console.log(n));
}
// solve(['add',
//     'add',
//     'add',
//     'add']);

// 4. Rotate Array
function solve(arr) {
    let rotations=arr.pop();
    for (let i = 0; i < rotations%arr.length; i++) {
        let n=arr.pop();
        arr.unshift(n);
    }
    console.log(arr.join(' '));
}
// solve(['Banana',
//     'Orange',
//     'Coconut',
//     'Apple',
//     '15']);

// 5. Extract Increasing Subsequence from Array

function solve(arr) {
    let max = Number.NEGATIVE_INFINITY;
    for (const n of arr) {
        if (n >= max) {
            max = n;
            console.log(n);
        }
    }
}
// solve([1,
//     3,
//     8,
//     4,
//     10,
//     12,
//     3,
//     2,
//     24]
// );

// 6. Sort Array
function solve(arr) {
    function sortByTwo(a,b) {
        if (a.length===b.length){
            return (a<b)?-1:1;
        } else return (a.length<b.length)?-1:1;
    }

    console.log(arr.sort(sortByTwo).join('\n'));
}
// solve(['Isacc',
// //     'Theodor',
// //     'Jack',
// //     'Harrison',
// //     'George']
// // );

// 7. Magic Matrices
function solve(matrix) {
    let result=true;
    let firstSum=matrix[0].reduce((a,b)=>a+b,0);
    for (let row = 1; row < matrix.length-1; row++) {
        if (matrix[row].reduce((a,b)=>a+b,0)!==firstSum) result = false;
    }
    let colSum;
    for (let col = 0; col < matrix[0].length-1; col++) {
        colSum=0;
        for (let row = 0; row < matrix.length; row++) {
            colSum+=matrix[row][col];
        }
    if (firstSum!==colSum) result=false;
    }
    console.log(result);
}
solve([[4, 5, 6],
    [6, 5, 4],
    [5, 5, 5]]
);