export function getDomElements() {
    return{
        // $angler:()=>document.querySelector("#addForm > input.angler"),
        // $weight:()=>document.querySelector("#addForm > input.weight"),
        // $species:()=>document.querySelector("#addForm > input.species"),
        // $location:()=>document.querySelector("#addForm > input.location"),
        // $bait:()=>document.querySelector("#addForm > input.bait"),
        // $captureTime:()=>document.querySelector("#addForm > input.captureTime"),
        // $addBtn:()=>document.querySelector("#addForm > button"),
        // $loadBtn:()=>document.querySelector("body > aside > button"),
        // $updateBtn:()=>document.querySelector("#catches > div > button.update"),
        // $deleteBtn:()=>document.querySelector("#catches > div > button.delete"),
        $catchForm:() => document.getElementById('addForm'),
        $mainDiv:()=>document.getElementById('catches'),
        $template:()=>getDomElements().$mainDiv().children[0],
    }
}