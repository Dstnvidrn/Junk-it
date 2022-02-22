function displayMessage(messageTxt) {
        var messageWindow = document.getElementById("message-window");
        messageWindow.textContent = messageTxt;}


                //Prompts user to confirm deletion of message
        function deleteMessage(){
            var deleteMsgForm = document.getElementById("deleteMessageForm");
            if (confirm("Are you sure? - DELETE MESSAGE")){

                deleteMsgForm.submit();
            }
        }
