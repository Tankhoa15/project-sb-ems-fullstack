import React from 'react'

const ListEmployeeComponent = () => {

    // create object array
    const dummydata = [
        {
            "id": 1,
            "firstName": "Tan",
            "lastName": "Khoa",
            "email": "tankhoa@gmail.com"
        },
        {
            "id": 2,
            "firstName": "Ngoc",
            "lastName": "Huynh",
            "email": "huynh@gmail.com"
        },
        {
            "id": 3,
            "firstName": "Kim",
            "lastName": "Khanh",
            "email": "khanh@gmail.com"
        }
    ]

  return (
    <div className='container'>
        <h2 className='text-center'>List Employees</h2>
        <table className='table table-striped table-hover table-bordered'>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee FirstName</th>
                    <th>Employee LastName</th>
                    <th>Employee Email</th>
                </tr>
            </thead>
            <tbody>
                {
                    dummydata.map(employee =>
                        <tr key={employee.id}>
                            <td>{employee.id}</td>
                            <td>{employee.firstName}</td>
                            <td>{employee.lastName}</td>
                            <td>{employee.email}</td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent

