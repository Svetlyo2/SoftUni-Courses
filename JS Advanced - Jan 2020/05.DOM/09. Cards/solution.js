function solve() {
    const result=document.querySelectorAll('#result span');
    const history=document.getElementById('history');
    let upperCard = 0;
    let upperCardNode;
    let bottomCard = 0;
    let bottomCardNode;
    let resultUpper=result[0];
    let resultBottom=result[2];

    let cards = document.querySelectorAll('section.cards img');
    Object.values(cards)
        .map(c => c.addEventListener('click', processCards));

    function processCards(e) {
        let card=e.target;
        let parentID = this.parentNode.getAttribute('id');
        let name = this.getAttribute('name');
        if (parentID === 'player1Div'&&upperCard === 0) {
            card.setAttribute('src', 'images/whiteCard.jpg');
            upperCard = Number(name);
            upperCardNode = card;
            resultUpper.textContent = name;
            card.removeEventListener('click',processCards);
        } else if (parentID === 'player2Div'&&bottomCard === 0) {
            card.setAttribute('src', 'images/whiteCard.jpg');
            bottomCard = Number(name);
            bottomCardNode = card;
            resultBottom.textContent = name;
            card.removeEventListener('click',processCards);
        }

        if ( upperCard !== 0 && bottomCard !== 0 && upperCard > bottomCard) {
            changeStyles(upperCardNode,bottomCardNode);
            history.textContent += `[${upperCard} vs ${bottomCard}] `;
            clearResult();
        } else if (upperCard < bottomCard && upperCard !== 0 && bottomCard !== 0) {
            changeStyles(bottomCardNode,upperCardNode);
            history.textContent += `[${upperCard} vs ${bottomCard}] `;
            clearResult();
        } else if (upperCard === bottomCard && upperCard !== 0 && bottomCard !== 0) {
            history.textContent += `[${upperCard} vs ${bottomCard}] `;
            clearResult()
        }

        function changeStyles(winner,loser) {
            winner.style = 'border: 2px solid green';
            loser.style = 'border: 2px solid red';
        }

        function clearResult() {
            resultUpper.innerHTML = '';
            resultBottom.innerHTML = '';
            upperCard = 0;
            bottomCard = 0;
        }
    }
}