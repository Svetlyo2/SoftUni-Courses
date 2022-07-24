function getDomElements(){
    return {
        $location:()=>document.getElementById('location'),
        $btn:()=>document.getElementById('submit'),
        $forecast:()=>document.getElementById('forecast'),
        $current:()=>document.getElementById('current'),
        $upcoming:()=>document.getElementById('upcoming'),
    }
}
function clearData(element) {
element.removeChild(element.lastChild)
}
export { getDomElements,clearData}