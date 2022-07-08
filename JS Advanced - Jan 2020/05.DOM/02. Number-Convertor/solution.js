function solve() {

    const select=document.getElementById('selectMenuTo');
    let toOption=document.querySelector('#selectMenuTo > option');

    function createOption(v,t){
        let option=document.createElement('option');
        option.value=v;
        option.innerText=t;
        select.appendChild(option);
    }
    createOption('binary','Binary');
    createOption('hexadecimal','Hexadecimal');

    const result=document.querySelector("#result");
    const input = document.getElementById('input');

    document.querySelector("#container > button")
        .addEventListener("click",convert);

    function convert() {
        let number=input.value;
        if (number==='') throw new Error('Enter a number');
        let selectionTo=select.value;
        console.log(selectionTo);
        if (selectionTo==='binary'){
            result.value= (+number).toString(2);
        } else if (selectionTo==='hexadecimal'){
            result.value= (+number).toString(16).toUpperCase();
        }
    }
}