function openSignUpModal() {
    $("#errorAlert").addClass("hide");
    $("#userName").val("");
    $("#password").val("");
    $('#modal3').toggle();
}

function openLoginModal() {
    $("#errorAlert").addClass("hide");
    $("#siuserName").val("");
    $("#sipassword").val("");
    $('#modal2').toggle();
}

$(document).ready(function() {
    $("#mod").on("click", function() {
        $("#demomodal").openModal();
    });

    $("#mode1,#mmode1").on("click", function() {
        $('#modal1').openModal();
        $("#postError").toggleClass("hide",true);
    });
    
    $("#mmode4").on("click", function() {
    	$('#modal4').openModal();
    	$("#postError").toggleClass("hide",true);
    });
    
    $(".button-collapse").sideNav();       
});

function closeModal(moddelId){
	$('#'+moddelId).toggle();
	return;
}

function openModal(e){
	$(e).next().openModal();
}

function attachCommentValue(e){
	var thisForm = e.parentNode.parentNode.parentNode;
	var post = thisForm.childNodes[7].childNodes[5].childNodes[1].childNodes[0].value.trim();
	$(thisForm).attr('action',$(thisForm).attr('action') + "?comments="+post);
}