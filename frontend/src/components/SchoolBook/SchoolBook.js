import React, {useEffect, useState} from 'react';
import { useParams } from "react-router-dom";
import PropTypes from 'prop-types';
import './SchoolBook.css';

const SchoolBook = () => {
  let pathParams = useParams();
  const clazz = pathParams.clazz;
  const [isLoaded, setIsLoaded] = useState(false);
  const [schoolBook, setSchoolBook] = useState([]);

    useEffect(() => {
      fetch(`/api/school-book/${pathParams.clazz}`)
        .then(res => res.json())
        .then(
          (result) => {
            setIsLoaded(true);
            setSchoolBook(result);
          },
          // Note: it's important to handle errors here
          // instead of a catch() block so that we don't swallow
          // exceptions from actual bugs in components.
          (error) => {
          setIsLoaded(false);
          }
        )
    }, [pathParams.clazz])

function isFirst(subject) {
  return subject === schoolBook.subjects[0];
}

function format(date) {
var options = {year: 'numeric', month: 'numeric', day: 'numeric'};
  return new Date(date).toLocaleDateString("uk-UA", options);
}

return (
pathParams.clazz && isLoaded && (
<div class="SchoolBook" key={pathParams.clazz}>
<nav>
    <div class="nav nav-tabs nav-dark" id="nav-tab" role="tablist">
            {schoolBook.subjects.map(subject => (
                                                         <button
                                                             class={`nav-link${isFirst(subject) ? ' active' : ''}`}
                                                             id={`nav-${subject.subject.id}-tab`}
                                                         data-bs-toggle="tab"
                                                         data-bs-target={`#nav-${subject.subject.id}`}
                                                         type="button" role="tab"
                                                         aria-controls={`#nav-${subject.subject.id}`}
                                                         aria-selected={`${isFirst(subject)}`}>
                                                         {subject.subject.title}
                                                         </button>
                                                   ))}
    </div>
</nav>
  <div class="tab-content" id="nav-tabContent">
{schoolBook.subjects.map(subject => (
 <div class={`tab-pane fade${isFirst(subject) ? 'show active' : ''}`} id={`nav-${subject.subject.id}`} role="tabpanel" aria-labelled-by={`nav-${subject.subject.id}-tab`}>
      <table class="table">
        <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">Name</th>
          {subject.schedules.map(schedule => (<th class="text-center" scope="col">{`${format(schedule)}`}</th>
        ))}
        </tr>
        </thead>
        <tbody>
        {subject.studentGrades.map((studentGrade, idx) => (
        <tr>
          <th scope="row">{idx+1}</th>
          <td>{studentGrade.student.firstName + ' ' + studentGrade.student.lastName}</td>
          {subject.schedules.map(schedule => (
          <td class="text-center">{studentGrade.grades[schedule]}</td>
          ))}
        </tr>
        ))}
        </tbody>
      </table>
    </div>
    ))}
  </div>

</div>
))

};

SchoolBook.propTypes = {};

SchoolBook.defaultProps = {};

export default SchoolBook;
