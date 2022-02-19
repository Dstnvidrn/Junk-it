
var messageContent = document.getElementById("messageContent");
var messageWindow = document.getElementById("message-window");
var replyTextBox = document.getElementById("reply-txt-box");
var replyButton = document.getElementById("messageInputButton");
var viewClick = document.getElementById("viewMessage");


viewClick.addEventListener("click", displayMessage);



function displayMessage() {
  messageWindow.textContent = messageContent.value;
}