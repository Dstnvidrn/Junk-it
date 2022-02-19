var composebox = document.getElementById("compose-messageBx");
var composeBtn = document.getElementById("composeBtn");

composeBtn.addEventListener("click",showMsgCompose);

function showMsgCompose() {
  if(composebox.style.display === "none"){
    composebox.style.display = "block";
  } else {
    composebox.style.display = "none";
  }
}
