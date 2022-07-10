function toggle() {
    const button=document.querySelector("#accordion > div.head > span");
    const extra=document.getElementById('extra');
    if (button.textContent==='More'){
        extra.style.display='block';
        button.textContent='Less'
    } else {
        extra.style.display='none';
        button.textContent='More'
    }
}