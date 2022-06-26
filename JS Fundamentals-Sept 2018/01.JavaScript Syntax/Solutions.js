// 1. Hello JavaScript!

function helloJS(name) {
    console.log('Hello, '+name+', I am JavaScript!');
}
// helloJS('Pesho');
// 2. Area and Perimeter
function solve(a,b) {
    console.log(a*b);
    console.log(2*(a+b));
}
// solve(1,3);

// 3. Distance over Time
function solve(arr) {
    let time=arr[2]/3600;
    let distance=Math.abs(arr[1]-arr[0])*time*1000;
    console.log(distance);
}
// solve([11, 10, 120]);

// 4. Distance in 3D
function solve(arr) {
    let distanceX=Math.abs(arr[3]-arr[0])**2;
    let distanceY=Math.abs(arr[4]-arr[1])**2;
    let distanceZ=Math.abs(arr[5]-arr[2])**2;
    let distance=Math.sqrt(distanceX+distanceY+distanceZ);
    console.log(distance)
}
// solve([3.5, 0, 1, 0, 2, -1]);

// 5. Grads to Radians
function solve(grads) {
    let degrees=grads*0.9%360;
    if (degrees<0) degrees+=360;
    console.log(degrees);
}
// solve(-50);
// 6. Compound Interest
function solve(arr) {
    let principal=arr[0];
    let interest=arr[1]/100;
    let compoundingFrequency= 12/arr[2];
    let years=arr[3];
    let result=principal*Math.pow((1+interest/compoundingFrequency),compoundingFrequency*years);
    // result=Math.round(result*100)/100;
    // console.log(result);
    console.log(result.toFixed(2));    
}
// solve([1500, 4.3, 3, 6]);

// 8. Imperial Units    
function solve(number) {
    console.log(Math.floor(number/12)+'\'-' + number%12+'\"');
}
// solve(11);

// 9. Now Playing
function solve(input) {
    let artistName=input[1];
    let trackName=input[0];
    let duration=input[2];
    // console.log('Now Playing: '+artistName+' - '+trackName+' ['+duration+']');
    console.log(`Now Playing: ${artistName} - ${trackName} [${duration}]`);
}
// solve(['Number One', 'Nelly', '4:09']);
// 10. Compose Tag
function solve(arr) {
    let location=arr[0];
    let altText=arr[1];
    let tag=`<img src="${location}" alt="${altText}">`;
    // console.log(`<img src="${location}" alt="${altText}">`);
    console.log(tag);
}
// solve(['smiley.gif', 'Smiley Face']);
// 11. Binary to Decimal
function solve(input) {
    let decimal=parseInt(input,2);
    // let decimal=parseInt(input,2).toString(10);
    console.log(decimal);
}
// solve('11110000');
// 12. Assign Properties
function solve(arr) {
    let obj={[arr[0]]: arr[1],[arr[2]]: arr[3],[arr[4]]: arr[5]};
    return obj;
}

console.log(solve(['name', 'Pesho', 'age', '23', 'gender', 'male']));
