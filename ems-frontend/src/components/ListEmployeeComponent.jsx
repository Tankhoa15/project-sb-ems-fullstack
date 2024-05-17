import React, {useEffect, useState} from 'react'
import { listEmployee } from '../service/EmployeeService'

const ListEmployeeComponent = () => {

    const [employees, setEmployees] = useState([])

    useEffect(() => {
        listEmployee().then((response) =>{
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    } ,[])

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
                    employees.map(employee =>
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

