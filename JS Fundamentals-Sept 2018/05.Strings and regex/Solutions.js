
// 1. Split a String with a Delimiter
function solve(string, delimiter) {
    console.log(string.split(delimiter).join('\n'));
}

// solve('One-Two-Three-Four-Five', '-');

// 2. Repeat a String N Times

function solve(string, number) {
    console.log(string.repeat(number));
}

// solve('magic is real', '3');

// 3. Starts With

function solve(str, substr) {
    console.log((str.indexOf(substr) === 0));
}

// solve('Marketing Fundamentals, starting 19/10/2016',
//     'Marketing Fundamentals, sta'
// );

// 4. Ends With
function solve(str, substr) {
    console.log((str.lastIndexOf(substr) === str.length - substr.length));
}

// solve('This is Houston, we have…',
//     'We have…'
// );

// 5. Capitalize the Words
function solve(str) {
    console.log(str.toLowerCase().split(" ").map(w => w[0].toUpperCase() + w.substr(1)).join(' '));
}

// solve('Was that Easy? tRY thIs onE for SiZe!');

// 6. Capture the Numbers
function solve(input) {
    let regex = /\d+/g;
    let text = input.join(' ');
    let numbers = text.match(regex);
    console.log(numbers.join(' '));
}

// solve(['The300',
//     'What is that?',
//     'I think it’s the 3rd movie.',
//     'Lets watch it at 22:45']
// );
// 7. Find Variable Names in Sentences

function solve(input) {
    let regex=/\b_([A-Za-z0-9]+\b)/g;
    let variables=input.match(regex).map(v=>v.slice(1));
    console.log(variables.join(','));
}
// solve('__invalidVariable _evenMoreInvalidVariable_ _validVariable');

// 8. Word Occurences
function solve(string,t) {
       let regex=new RegExp('\\b'+t+'\\b', 'gi');
       let count=0;
    let result = regex.exec(string);
    while (result){
        count++;
        result = regex.exec(string);
    }
    console.log(count);
       // let res = string.match(regex);
       // console.log(res.length);
}
// solve('There was one. Therefore I bought it. I wouldn’t buy it otherwise.',
//     'there');

