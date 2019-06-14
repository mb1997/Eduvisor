<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib name="forms" uri="http://www.springframework.org/tags/form" %>
<!-- ALL ELEMENTS WILL BE PLACED IN THE HEADER.JSP FILE
SO ONLY THING YOU NEED TO DO IS TO CREATE SECTION WITH CLASS CONTAINER AND MAIN-CONTENT

SAME AS FOOTER YOU ONLY NEED TO ADD FOOTER.JSP TO INCLUDE FOOTER

AND YOU NEED TO ADD SCRIPTS.JSP TO ADD JAVASCRIPTS TO YOUR CODE

YOU NEED TO ADD ALL THE 3 INCLUDE FILES THEN ONLY YOU CAN USE PAGE PROPERLY WITH TEMPLATE
-->

<!-- HEADER FILE INCLUDED HERE -->
<jsp:include page="include/header.jsp"></jsp:include>

<!-- MAIN BODY STARTS HEERE -->
	<section class="container main-content">
		<div class="login">
			<div class="row">


				<!-- LOGIN    (STARTS HERE) -->
				<div class="col-md-6">
					<div class="page-content">
						<h2>Login</h2>
						<div class="form-style form-style-3">
							<forms:form>
								<div class="form-inputs clearfix">
									<p class="login-text">
										<forms:input type="text" value="Username" />
										<i class="icon-user"></i>
									</p>
									<p class="login-password">
										<forms:input type="password" value="Password" />
										<i class="icon-lock"></i>
										<a href="#">Forget</a>
									</p>
								</div>
								<p class="form-submit login-submit">
									<input type="submit" value="Log in" class="button color small login-submit submit">
								</p>
								<div class="rememberme">
									<label><forms:input type="checkbox" /> Remember Me</label>
								</div>
							</forms:form>
						</div>
					</div><!-- End page-content -->
				</div><!-- End col-md-6 -->
				<!-- LOGIN    (ENDS HERE) -->



				<!-- REGISTRATION  (STARTS HERE) -->
				<div class="col-md-6">
					<div class="page-content">
						<h2>Register Now</h2>
						<div class="form-style form-style-3">
							<forms:form>
								<div class="form-inputs clearfix">
									<p>
										<label class="required">Name<span>*</span></label>
										<forms:input type="text" />
									</p>
									<p>
										<label class="required">E-Mail<span>*</span></label>
										<forms:input type="email" />
									</p>
									<p>
										<label class="required">Contact Number<span>*</span></label>
										<forms:input type="text" />
									</p>
									<p>
										<label class="required">Current Profession<span>*</span></label>
										<forms:select>
											<option selected disabled>Select Profession</option>
											<option>Student</option>
											<option>Professor</option>
										</forms:select>
									</p>
									<p>
										<label class="required">Password<span>*</span></label>
										<forms:input type="password" />
									</p>
									<p>
										<label class="required">Confirm Password<span>*</span></label>
										<forms:input type="password" />
									</p>
								</div>
								<p class="form-submit">
									<input type="submit" value="Signup" class="button color small submit">
								</p>
							</forms:form>
						</div>
					</div><!-- End page-content -->
				</div><!-- End col-md-6 -->
				<!-- REGISTRATION    (ENDS HERE) -->



			</div><!-- End row -->
		</div><!-- End login -->
	</section><!-- End container -->
<!-- MAIN BODY ENDS HERE -->	

<!-- FOOTER FILE INCLUDED HERE -->
<jsp:include page="include/footer.jsp"></jsp:include>


<!-- SCRIPTS FILE INCLUDE -->
<jsp:include page="include/scripts.jsp"></jsp:include>