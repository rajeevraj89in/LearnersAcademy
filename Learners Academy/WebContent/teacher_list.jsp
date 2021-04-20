<jsp:include page="/include/header.jsp"></jsp:include>
<%@ page import="com.learners.hibernate.entity.Teacher"%>
<%@ page import="java.util.List"%>
<!-- Begin Page Content -->
<div class="container-fluid">

	<!-- Page Heading -->
	<h1 class="h3 mb-2 text-gray-800">Teacher List</h1>
	<!-- <p class="mb-4">
		DataTables is a third party plugin that is used to generate the demo
		table below. For more information about DataTables, please visit the <a
			target="_blank" href="https://datatables.net">official DataTables
			documentation</a>.
	</p> -->

	<!-- DataTales Example -->
	<div class="card shadow mb-4">
		<div class="card-header py-3">
			<a class="btn btn-md btn-primary" href="">Add Teacher</a>
		</div>
		<div class="card-body">
			<div class="table-responsive">
				<table class="table table-bordered" id="dataTable" width="100%"
					cellspacing="0">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Contact No</th>
							<th>Qualification</th>
							<th>Address</th>
						</tr>
					</thead>
					<tfoot>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Email</th>
							<th>Contact No</th>
							<th>Qualification</th>
							<th>Address</th>
						</tr>
					</tfoot>
					<tbody>
						<%
							List<Teacher> teacher = (List<Teacher>) request.getAttribute("listteacher");
							for (Teacher tech : teacher) {
								out.print("<tr><td>" + tech.getId() + "</td><td>" + tech.getName() + "</td><td>" + tech.getEmail()
										+ "</td><td>" + tech.getContactNo() + "</td><td>" + tech.getQualification() + "</td><td>" + tech.getAddress()
										+ "</td></tr>");
							}
						%>
					</tbody>
				</table>
			</div>
		</div>
	</div>

</div>
<!-- /.container-fluid -->
<jsp:include page="/include/footer.jsp"></jsp:include>
