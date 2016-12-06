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