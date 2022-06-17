<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>테스트</title>

  	<%@ include file="/WEB-INF/views/includes/commonCss.jsp" %>
  
</head>

<body id="page-top">

    <!-- Page Wrapper -->
    <div id="wrapper">

        <!-- Sidebar -->
		<%@ include file="includes/SideBar.jsp" %>
        <!-- End of Sidebar -->

        <!-- Content Wrapper -->
        <div id="content-wrapper" class="d-flex flex-column">

            <!-- Main Content -->
            <div id="content">

                <!-- Topbar -->
				<%@ include file="includes/TopBar.jsp" %>
                <!-- End of Topbar -->

                <!-- Begin Page Content -->
                <div class="container-fluid">

                    <!-- Page Heading -->
                    <div class="d-sm-flex align-items-center justify-content-between mb-4">
                        <h1 class="h3 mb-0 text-gray-800">테스트페이지 - TestPage.jsp</h1>
                    </div>
                    
					<!--  Content Row -->
					<input type="text" id="username" placeholder="보내는 사람">
					<br>
					<input type="text" id="comment" placeholder="내용">
					<button onclick="msgSendTest()">테스트 버튼</button>
					<div id = "receiveMsg">
					
					</div>
					<!--  Content Row -->

					<!--  Content Row -->

                </div>
                <!-- /.container-fluid -->

            </div>
            <!-- End of Main Content -->

            <!-- Footer -->
            <footer class="sticky-footer bg-white">
                <div class="container my-auto">
                    <div class="copyright text-center my-auto">
                        <span>Copyright &copy; Your Website 2021</span>
                    </div>
                </div>
            </footer>
            <!-- End of Footer -->

        </div>
        <!-- End of Content Wrapper -->

    </div>
    <!-- End of Page Wrapper -->

    <!-- Scroll to Top Button-->
    <a class="scroll-to-top rounded" href="#page-top">
        <i class="fas fa-angle-up"></i>
    </a>

 
    <!-- Bootstrap core JavaScript-->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath }/resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

    <!-- Core plugin JavaScript-->
    <script src="${pageContext.request.contextPath }/resources/vendor/jquery-easing/jquery.easing.min.js"></script>

    <!-- Custom scripts for all pages-->
    <script src="${pageContext.request.contextPath }/resources/js/sb-admin-2.min.js"></script>
    
    <!-- sockJs -->
    <script src="https://cdn.jsdelivr.net/npm/sockjs-client@1/dist/sockjs.min.js"></script>
    
    <script type="text/javascript">
    	var testUrl = "${pageContext.request.contextPath }/testWskMessage";
	    var sock = new SockJS(testUrl);
	    sock.onopen = function() {
	        console.log('open');
	    };
	
	    sock.onmessage = function(e) {
	       // console.log('message', e.data);
	        
	        var receiveData = JSON.parse(e.data);
	        console.log(receiveData);
	        
	       // var output = "<p>"+e.data+"</p>";
	        
	        var output = "<p>"+receiveData.msgUserId+"</p>";
	        output += "<p>"+receiveData.msgComment+"</p>";
	        
	       // $("#receiveMsg").html(output);
	        $("#receiveMsg").append(output);
	        				// 선택한 요소의 마지막 부분에 인자값을 추가
	    };
	
	    sock.onclose = function() {
	        console.log('close');
	    };
    </script>
    
    <script type="text/javascript">
    	function msgSendTest(){
    		var username = $("#username").val();
    		var comment = $("#comment").val();
    		$("#comment").val("");
    		var msgData = {
    			msgUserId : username,
    			msgComment : comment
    		};
			//console.log(msgData);
			console.log(JSON.stringify(msgData));
			// JSON 형태의 string으로 변환하여 전송
			
    		//sock.send(msgData);
    		sock.send(JSON.stringify(msgData));
    		// send: handleTextMessage 호출. 클라이언트가 서버로 데이터 전송
    	}
    </script>
    
    <script type="text/javascript">
    	var checkMsg = "${msg}"
    	console.log(checkMsg.length);
    	if(checkMsg.length > 0){
    		alert(checkMsg);
    	}

    </script>
    
    

</body>

</html>