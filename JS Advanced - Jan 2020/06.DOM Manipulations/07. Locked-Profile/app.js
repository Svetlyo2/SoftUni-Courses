function lockedProfile() {
    const profiles=document.getElementsByClassName('profile');
    Array.from(profiles)
        .map(p=>p.addEventListener('click',function(e){
        const elements=p.children;
        if (e.target===elements[2]){
            lockUnlock(elements[2],elements[4]);
            // console.log(elements[4].checked)
        }
        if (e.target===elements[4]) {
            lockUnlock(elements[4], elements[2]);
        }
        if (e.target===elements[10] && elements[4].checked===true){
            if (elements[9].style.display==='block'){
                elements[9].style.display='none';
                elements[10].textContent='Show more'
            } else {
                elements[9].style.display='block';
                elements[10].textContent='Hide it'
            }
        }
            function lockUnlock(lock, unlock) {
                lock.checked = true;
                unlock.checked = false;
            }
    }));
}