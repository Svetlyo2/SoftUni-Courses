function subtract2() {
    const firstNumber=document.getElementById('firstNumber');
    const secondNumber=document.getElementById('secondNumber');
    const result=document.getElementById('result');
    const wrapper=document.getElementById('wrapper');

    firstNumber.disabled=false;
    secondNumber.disabled=false;
    let difference =Number(firstNumber.value)-Number(secondNumber.value);
    result.textContent=difference+'';
    wrapper.addEventListener('input',function () {
        difference =Number(firstNumber.value)-Number(secondNumber.value);
        if (firstNumber && secondNumber){
            result.textContent=difference+'';
        }
    })
}
function subtract() {
    document.getElementById("result").textContent = (Number(document.getElementById("firstNumber").value) -
        Number(document.getElementById("secondNumber").value))+'';

}