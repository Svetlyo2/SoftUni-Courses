function solve() {
        let sections=Array.from(document
            .querySelectorAll("#quizzie > section"));
    let sectionIndex=0;
    const result=document.querySelector('#results h1');
   let answers= Array.from(document.querySelectorAll(".answer-text"))
       .map(x=>x.addEventListener('click', checkAnswer));
    let rightAnswersCount=0;
    let rightAnswers=['onclick',
                    'JSON.stringify()',
        'A programming API for HTML and XML documents'];

    function checkAnswer(e) {
        if (e.target && rightAnswers.includes(e.target.innerText))
            {rightAnswersCount++}
        sections[sectionIndex].style.display='none';
        sectionIndex++;
        if (sectionIndex>2){
            document.querySelector("#results").style.display='block';
            if (rightAnswersCount===3)
            result.innerText="You are recognized as top JavaScript fan!";
            else result.innerText=`You have ${rightAnswersCount} right answers`;
            return;
        }
        sections[sectionIndex].classList.remove('hidden');
        sections[sectionIndex].style.display='block';
    }
}
