function solve() {
    let message=document.getElementById('chat_input');
    const sendBtn=document.getElementById('send');
    const messages=document.getElementById('chat_messages');

    function sendMessage() {
        if (!message) {
    throw new Error("Write a message")
        }
        let newMessage=document.createElement('div');
        newMessage.setAttribute('class', 'message my-message');
        newMessage.innerText=message.value;
        messages.appendChild(newMessage);
        message.value='';
    }
    sendBtn.addEventListener('click',sendMessage);
}


