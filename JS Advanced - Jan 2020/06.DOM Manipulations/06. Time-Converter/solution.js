function attachEventsListeners() {
    const buttons=document.querySelectorAll("body input[type=button]");
    const input=document.querySelectorAll("body input[type=text]");
    Object.values(buttons).map(b=>b.addEventListener('click',convert));
    let days;

    function convert(e) {
        if (e.target.id==="daysBtn"){
            days=+e.target.parentNode.children[1].value;
        } else if (e.target.id==='hoursBtn'){
            days=Number(e.target.parentNode.children[1].value)/24;
        }else if (e.target.id==='minutesBtn'){
            days=Number(e.target.parentNode.children[1].value)/1440;
        }else if (e.target.id==='secondsBtn'){
            days=Number(e.target.parentNode.children[1].value)/86400;
        }
        calculateResult(days);
    }

    function calculateResult(days) {
        const daysConversion={
            days: days,
            hours: days*24,
            minutes: days*1440,
            seconds: days*86400
        };
        printResult(daysConversion)
    }
    function printResult(obj) {
        input[0].value=obj['days'];
        input[1].value=obj['hours'];
        input[2].value=obj['minutes'];
        input[3].value=obj['seconds'];
    }

}