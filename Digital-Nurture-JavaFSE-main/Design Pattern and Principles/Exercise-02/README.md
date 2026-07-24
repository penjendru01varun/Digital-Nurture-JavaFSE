# Exercise 2: Implementing the Factory Method Pattern

## Objective
Develop a document management system that needs to create different types of documents (e.g., Word, PDF, Excel) using the Factory Method Pattern.

## Technologies Used
- Java 17

## Files Included
- `Document.java`: Interface representing a document.
- `WordDocument.java`, `PdfDocument.java`, `ExcelDocument.java`: Concrete classes implementing `Document`.
- `DocumentFactory.java`: Abstract class representing the factory method `createDocument()`.
- `WordDocumentFactory.java`, `PdfDocumentFactory.java`, `ExcelDocumentFactory.java`: Concrete factories for creating respective documents.
- `TestFactory.java`: Test class demonstrating the creation of different document types using the factory method.

## Output Screenshot
```text
Opening Word Document.
Saving Word Document.
Opening PDF Document.
Saving PDF Document.
Opening Excel Document.
Saving Excel Document.
```
