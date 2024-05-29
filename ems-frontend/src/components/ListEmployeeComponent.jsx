import React, {useEffect, useState} from 'react'
import { listEmployee } from '../service/EmployeeService'
import { useNavigate } from 'react-router-dom'

const ListEmployeeComponent = () => {

    const [employees, setEmployees] = useState([])

    const navigator = useNavigate();

    useEffect(() => {
        listEmployee().then((response) =>{
            setEmployees(response.data);
        }).catch(error => {
            console.error(error);
        })
    } ,[])

    function addNewEmployee(){
        navigator('/add-employee');
    }

  return (
    <div className='container'>
        <h2 className='text-center'>List Employees</h2>
        <button className='btn btn-primary mb-2' onClick={addNewEmployee}>Add</button>
        <table className='table table-striped table-hover table-bordered'>
            <thead>
                <tr>
                    <th>Employee ID</th>
                    <th>Employee FirstName</th>
                    <th>Employee LastName</th>
                    <th>Employee Email</th>
                    <th>Actions</th>
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
                            <td>
                                <button></button>
                            </td>
                        </tr>
                    )
                }
            </tbody>
        </table>
    </div>
  )
}

export default ListEmployeeComponent

