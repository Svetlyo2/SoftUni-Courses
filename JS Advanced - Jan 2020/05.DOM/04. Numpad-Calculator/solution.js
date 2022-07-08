function solve() {
    // const operators = ['/', '*', '-', '+'];
    const expressionOutput=document.getElementById("expressionOutput");
    const resultOutput=document.getElementById("resultOutput");
    let expresion='';

    let keys=Array.from(document.getElementsByTagName('BUTTON'));
        keys.map(b=>b.addEventListener('click',checkInput));

    function checkInput(e) {
        if (!e.target) throw new Error('Invalid input');
        let value=e.target.value;
        if (value==='Clear'){
            expressionOutput.innerHTML='';
            expresion='';
            resultOutput.innerText='';
        } else if (value!=='=') {
            if (value === '+' || value === '-' || value === '*' || value === '/') {
                value = ` ${value} `;
                // console.log(value);
                expresion+=value;
                expressionOutput.innerHTML = expresion
            }
            else {expresion+=value;
                expressionOutput.innerText=expresion}
        } else {
            let result='';
            if (!isNaN(calc(expresion))){
                result=calc(expresion);

            } else {
                result='NaN';
            }
            resultOutput.innerText=''+result;
        }
    }

    function calc(exp) {
        let input=exp.split(' ').filter(x=>x!=='');

        let operand=input[1];
        let x=Number(input[0]);
        let y=Number(input[2]);
        if (isNaN(input[0])|| isNaN(input[2])|| input[2]===null) return NaN;
        // console.log(input+','+y);
        let calcResult=0;
        if (operand==='+')
            calcResult=x+y;
        else if (operand==='-')
            calcResult=x-y;
        else if (operand==='*')
            calcResult=x*y;
        else if (operand==='/')
            calcResult=x/y;
        // console.log(calcResult);
        return calcResult;
    }
}
