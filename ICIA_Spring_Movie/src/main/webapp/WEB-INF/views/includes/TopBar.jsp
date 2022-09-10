<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

    <!-- TobBar.jsp -->
    
    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

        <!-- Sidebar Toggle (Topbar) -->
        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
            <i class="fa fa-bars"></i>
        </button>

        <!-- Topbar Search -->
        <form action="searchMovie" method="get"
            class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search">
            <div class="input-group">
                <input type="text" class="form-control bg-light border-0 small" placeholder="Search for..."
                    name="searchText" aria-label="Search" aria-describedby="basic-addon2">
                <div class="input-group-append">
                    <button class="btn btn-primary" type="submit">
                        <i class="fas fa-search fa-sm"></i>
                    </button>
                </div>
            </div>
        </form>

        <!-- Topbar Navbar -->
        <ul class="navbar-nav ml-auto">

            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
            <li class="nav-item dropdown no-arrow d-sm-none">
                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-search fa-fw"></i>
                </a>
                <!-- Dropdown - Messages -->
                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in"
                    aria-labelledby="searchDropdown">
                    <form action="searchMovie" method="get"
                    		class="form-inline mr-auto w-100 navbar-search">
                        <div class="input-group">
                            <input type="text" class="form-control bg-light border-0 small"
                                placeholder="Search for..." aria-label="Search"
                                name="searchText"  aria-describedby="basic-addon2">
                            <div class="input-group-append">
                                <button class="btn btn-primary" type="submit">
                                    <i class="fas fa-search fa-sm"></i>
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
            </li>

		<c:choose>
		<c:when test="${sessionScope.loginId != null }">
            <!-- Nav Item - Alerts -->
            <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-bell fa-fw"></i>
                    <!-- Counter - Alerts -->
                    <c:if test="${sessionScope.recentReCount > 0 }">
                     <span class="badge badge-danger badge-counter">${sessionScope.recentReCount }</span>
                    </c:if>
                </a>
                <!-- Dropdown - Alerts -->
                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                    aria-labelledby="alertsDropdown" id="bellDropdown" style="width:23rem!important;">
                   
                </div>
            </li>

<%--             <!-- Nav Item - Messages -->
            <li class="nav-item dropdown no-arrow mx-1">
                <a class="nav-link dropdown-toggle" href="#" id="messagesDropdown" role="button"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <i class="fas fa-envelope fa-fw"></i>
                    <!-- Counter - Messages -->
                    <span class="badge badge-danger badge-counter">7</span>
                </a>
                <!-- Dropdown - Messages -->
                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in"
                    aria-labelledby="messagesDropdown">
                    <h6 class="dropdown-header">
                        Message Center
                    </h6>
                    <a class="dropdown-item d-flex align-items-center" href="#">
                        <div class="dropdown-list-image mr-3">
                            <img class="rounded-circle" src="${pageContext.request.contextPath }/resources/img/undraw_profile_1.svg"
                                alt="...">
                            <div class="status-indicator bg-success"></div>
                        </div>
                        <div class="font-weight-bold">
                            <div class="text-truncate">Hi there! I am wondering if you can help me with a
                                problem I've been having.</div>
                            <div class="small text-gray-500">Emily Fowler · 58m</div>
                        </div>
                    </a>
                    <a class="dropdown-item d-flex align-items-center" href="#">
                        <div class="dropdown-list-image mr-3">
                            <img class="rounded-circle" src="${pageContext.request.contextPath }/resources/img/undraw_profile_2.svg"
                                alt="...">
                            <div class="status-indicator"></div>
                        </div>
                        <div>
                            <div class="text-truncate">I have the photos that you ordered last month, how
                                would you like them sent to you?</div>
                            <div class="small text-gray-500">Jae Chun · 1d</div>
                        </div>
                    </a>
                    <a class="dropdown-item d-flex align-items-center" href="#">
                        <div class="dropdown-list-image mr-3">
                            <img class="rounded-circle" src="${pageContext.request.contextPath }/resources/img/undraw_profile_3.svg"
                                alt="...">
                            <div class="status-indicator bg-warning"></div>
                        </div>
                        <div>
                            <div class="text-truncate">Last month's report looks great, I am very happy with
                                the progress so far, keep up the good work!</div>
                            <div class="small text-gray-500">Morgan Alvarez · 2d</div>
                        </div>
                    </a>
                    <a class="dropdown-item d-flex align-items-center" href="#">
                        <div class="dropdown-list-image mr-3">
                            <img class="rounded-circle" src="https://source.unsplash.com/Mv9hjnEUHR4/60x60"
                                alt="...">
                            <div class="status-indicator bg-success"></div>
                        </div>
                        <div>
                            <div class="text-truncate">Am I a good boy? The reason I ask is because someone
                                told me that people say this to all dogs, even if they aren't good...</div>
                            <div class="small text-gray-500">Chicken the Dog · 2w</div>
                        </div>
                    </a>
                    <a class="dropdown-item text-center small text-gray-500" href="#">Read More Messages</a>
                </div>
            </li> --%>

            <div class="topbar-divider d-none d-sm-block"></div>

            <!-- Nav Item - User Information -->
            
            <li class="nav-item dropdown no-arrow">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button"
                    data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.loginId}</span>
                   	<c:choose>
                    <c:when test="${sessionScope.mprofile != null }">
                    	<c:choose>
	                     	<c:when test="${sessionScope.mstate == 2}">
	                      	<img class="img-profile rounded-circle"
	                          src="${sessionScope.mprofile}">
	                     	</c:when>
							<c:otherwise>
	                      	<img class="img-profile rounded-circle"
	                          src="${pageContext.request.contextPath }/resources/mprofileUpload/${sessionScope.mprofile}">
							</c:otherwise>                                	
                    	</c:choose>
                    </c:when>
                    <c:otherwise>
                    	<img class="img-profile rounded-circle"
                        src="${pageContext.request.contextPath }/resources/img/undraw_profile.svg">
                    </c:otherwise>
                    </c:choose>
                </a>
                <!-- Dropdown - User Information -->
                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in"
                    aria-labelledby="userDropdown">
                    <a class="dropdown-item" href="memberInfoForm">
                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                        내정보
                    </a>
                    <a class="dropdown-item" href="movieReservationPage">
                        <i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>
                        영화예매
                    </a>
                    <a class="dropdown-item" href="reservationList?loginId=${sessionScope.loginId }">
                        <i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>
                        예매내역
                    </a>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                        로그아웃
                    </a>
                </div>
            </li>
        </c:when>
        <c:otherwise>
        	 <li class="nav-item dropdown no-arrow">
                <a class="nav-link" href="memberLoginForm" >
                    <span class="mr-2 d-lg-inline text-gray-600 small">로그인</span>
                </a>
            </li>
        </c:otherwise>
        </c:choose>

        </ul>

    </nav>
                
                   <!-- Logout Modal-->
    <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">로그아웃 하시겠습니까?</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">'확인'을 선택하면 로그아웃됩니다.</div>
                <div class="modal-footer">
                    <a class="btn btn-primary" href="memberLogout">확인</a>
                    <button class="btn btn-secondary" type="button" data-dismiss="modal">취소</button>
                </div>
            </div>
        </div>
    </div>
    
    <div class="modal fade" id="reInfoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
        aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h6 class="modal-title font-weight-bold " id="exampleModalLabel">예매되었습니다.</h6>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">×</span>
                    </button>
                </div>
                <div class="modal-body">
                  	<div class="row">
                        <div class="col-5">
                            <div class="h6 mb-3 font-weight-bold text-gray-800" >
                             	<img class="img-fluid" alt="영화포스터" style="max-height:300px;" id="reservMsg_mvposter" src="">
                            </div>
                        </div>
                        <div class="col-7">
                            <div class="h6 my-3 font-weight-bold text-gray-800">
                            	<div class="p-2 font-weight-bold" id="reservMsg_recode"></div>
                            	<div class="p-2 font-weight-bold" id="reservMsg_mvname"></div>
                            	<div class="p-2 font-weight-bold" id="reservMsg_thname"></div>
                            	<div class="p-2 font-weight-bold" id="reservMsg_rescdate"></div>
                            	<div class="p-2 font-weight-bold" id="reservMsg_reamount"></div>
                            </div>
                         </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath }">확인</a>
                </div>
            </div>
        </div>
    </div>
    
    
        <!-- Bootstrap core JavaScript-->
   <script src="${pageContext.request.contextPath }/resources/vendor/jquery/jquery.min.js"></script>
    
   <script type="text/javascript">
		$(document).ready(function() {
			$("#alertsDropdown").click(function(){
				console.log("클릭 실행");
				var loginId = "${sessionScope.loginId}";
				
				$.ajax({
					type: "post",
					data: {"loginId":loginId},
					url: "recentReservation",
					dataType: "json",
					success: function(rvList){
						console.log("연결 성공");
						console.log(rvList);
						var output = "<h6 class='dropdown-header'>관람예정 예매목록</h6>";
						for(var i = 0; i < rvList.length; i++){
							output += "<a class='dropdown-item d-flex align-items-center' href='reservationInfo?recode="+rvList[i].recode+"'>";
							output += "<div class='mr-3'>";
							output += "<div class='icon-circle bg-primary'>";
							output += "<i class='fas fa-bell fa-fw text-white'></i>";
							output += "</div></div>";
							output += "<div>";
							output += "<div>";
							output += " <span class='small text-gray-700'>"+rvList[i].rescdate+"</span>";
							output += " <span class='small text-gray-700'>"+rvList[i].thname+"</span>";
							output += " <span class='small text-gray-700'>"+rvList[i].rescroom+"</span>";
							output += " </div>";
							output += "<span class='font-weight-bold'>"+rvList[i].mvname+"</span>";
							output += " </div> </a>";
						}
						$("#bellDropdown").text("");
						$("#bellDropdown").html(output);
					}
				});
			});
		});
    </script>
                