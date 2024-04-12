-- tables should be created by Spring Boot persistance mechanism as we set
-- spring.jpa.hibernate.dll-auto=update in the application.properties

-- apply below insert statements if was not already inserted
INSERT INTO course (id, description, cost, title)
VALUES (1, 'An introductory course covering the fundamentals of object-oriented programming.', 150,
        'Introduction to Programming') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (2, 'A course covering the learning objectives for the latest OCPJP certification.', 350,
        'OCPJP Exam Preparation') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (3, 'An intermediate course on how to make the most of Spring Boot''s latest functionality.', 200,
        'Spring Boot') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (4, 'Gain an in-depth understanding of the ''Internet of Things'' paradigm and how smart devices can be designed and deployed for a connected world.',650,
        'Smart Systems') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (5, 'Develop an awareness of the methods and skills required to carry out Masters level research successfully. You''ll reflect critically on your own development in the context of your chosen programme of study.',550,
        'Research Practice') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (6, 'Develop your knowledge so you can initiate, plan, execute, manage and sign off a project. Emphasis will be placed on appropriate methodologies, standards, legislation and the nine core knowledge areas associated with project management. You''ll be challenged during your learning and assessments to relate to your own experiences and/or organisations.', 700,
        'Project Management') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (7, 'Learn about the fundamental principles and approaches for Intelligent Systems, autonomous behaviour, sensing and control, through the practical example of a simple robotic device (Delta Robot). You''ll have opportunity to work practically with the robot and develop software for simple behavioural and reaction patterns of robotic devices.', 725,
        'Intelligent Systems and Robotics') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (8, 'This module provides the opportunity to engage in research or advanced scholarship in a subject area that is appropriate to your award and is of particular interest to you. You''ll carry out an in-depth research project, which will be discussed in a formal dissertation and viva.', 1000,
        'Dissertation') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (9, 'Examine how to build cloud services and the technologies required to provide these to client-side systems. Well established protocols that are used to communicate with server-side software will also be examined, as will consideration for aspects such as security and n-tier systems.', 650,
        'Cloud Computing Development') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (10, 'This module covers the principles of monitoring network performance and gathering network management data. You''ll learn to extract network parameters using industry standard tools like OpenNMS and PRTG. You''ll also be trained on SNMP protocol and will be able to put this into context of management of corporate networks.', 600,
        'Network Management') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (11, 'This module provides an in-depth look at the Service-Oriented Architecture paradigm and, more specifically, at its recent development: Microservices. You will gain theoretical knowledge of software design using a modular, loosely coupled approach, as well as practical experience with implementation tools and techniques highly valued in the industry.', 800,
        'Software Engineering for Service Computing') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (12, 'Gain an in-depth, systematic and critical understanding of the current research on data intelligence and issues concerning data analysis and knowledge discovery. You''ll also look at techniques for data analysis from both a theoretical and practical perspective.', 670,
        'Applied Data Analytics') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (13, 'Understand the techniques involved in systems programming - you''ll study various approaches of design and programming modern day computer systems at a very intricate level.', 450,
        'Software and Systems') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (14, 'This module will give you the opportunity to broaden and deepen your knowledge in your chosen areas of study. Working with your module tutor and project supervisor, you''ll research and apply current theory and practice to develop high level skills within a framework of self-directed learning.', 580,
        'Negotiated Skills Development') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (15, 'This module provides an introduction to reverse-engineering malware binaries for the x86 architecture. You will be introduced to low level programming languages such as C and assembly language and will develop practical and theoretical skills to enable you to perform both static and dynamic analysis of malware code. This module also takes an in-depth look at typical malware behaviour and how to leverage state-of-the-art reverse-engineering tools to facilitate your analysis.', 850,
        'Reverse Engineering and Malware Analysis') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (16, 'This module will introduce modern image/video processing techniques and applications in digital forensic investigation. You''ll learn concepts of digital image/video processing application and how to apply techniques such as image filtering, de-nosing, enhancement and restoration methods in different scenarios.', 720,
        'Forensic Image and Video Processing') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (17, 'Deepen your understanding and experience of the technical underpinnings of software security. You''ll gain experience with software vulnerabilities and will review code with software design and implementation bugs (including buffer overflows, injection attacks, and other faults). You''ll audit code for the presence of security vulnerabilities both manually and using advanced approaches such as fuzz-testing and static analysis. You''ll apply mitigation techniques to remove vulnerabilities from software.', 550,
        'Software Security and Exploitation') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (18, 'This is an introduction to the theories and methods that are core to historical research. You will study research skills and methods, exploring libraries, sources, archives and treatments of history using case studies. You will analyse the relationships between literary texts, historical documents, and films, as well as scrutinising how events have been recorded, historicised, fictionalised and dramatised.', 550,
        'Researching Cultures') ON CONFLICT (ID) DO NOTHING;
INSERT INTO course (id, description, cost, title)
VALUES (19, 'Examine the social, cultural and political history of Britain in the ''long 1960s'' (c. 1956-1974) – the period which saw a ''cultural revolution''. You''ll study various forms of cultural production in the context of social and political changes in Britain.', 350,
        'Britain in the Sixties: A Cultural Revolution') ON CONFLICT (ID) DO NOTHING;
