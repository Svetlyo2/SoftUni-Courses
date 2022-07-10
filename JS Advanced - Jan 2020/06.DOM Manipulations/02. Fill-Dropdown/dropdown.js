function addItem() {
    const newItemText=document.getElementById('newItemText');
    const newItemValue=document.getElementById('newItemValue');
    const menu=document.getElementById('menu');

    let option=document.createElement('option');
    option.value=newItemValue.value.trim();
    option.textContent=newItemText.value.trim();
    if (option&&newItemValue.value&&newItemText.value){
        menu.appendChild(option);
        newItemText.value='';
        newItemValue.value='';
    }
}
