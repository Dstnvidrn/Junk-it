var composebox = document.getElementById("compose-messageBx");
var composeBtn = document.getElementById("composeBtn");
var messageWindow = document.getElementById("message-window");
var composeForm = document.getElementById("composeForm");
var inputTextBox = document.getElementById("reply-txt-box");
composeForm.addEventListener("submit", sendAlert);


composeBtn.addEventListener("click",toggleInputBox);


function sendAlert() {
  alert("Message Sent.")
}
function toggleInputBox() {
  if(composebox.style.display == "none"){
    composebox.style.display = "block";
  } else {
    composebox.style.display = "none";
  }
}


