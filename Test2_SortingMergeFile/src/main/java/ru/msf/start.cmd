@if not exist C:\projects\Tests\Test2_SortingMergeFile goto :error1
@if not exist C:\projects\tmp\resources goto :error2
@echo -------------
@echo ����� �ணࠬ�� ��� ��ࠬ��஢ (�ࠡ�⠥� Demo-�����. ᮧ�������� 䠩�� out1.txt � out4.txt � ��४�ਨ C:\projects\tmp\resources)
java -Dfile.encoding=UTF-8 -classpath C:\projects\Tests\Test2_SortingMergeFile\target\classes ru.msf.SortIt
@call :dirtmp

@echo -------------
@echo ����� �ணࠬ�� � ��ࠬ��ࠬ� (ᮧ������� 䠩� out.txt � ��४�ਨ C:\projects\tmp\resources)
java -Dfile.encoding=UTF-8 -classpath C:\projects\Tests\Test2_SortingMergeFile\target\classes ru.msf.SortIt -i -d out.txt in1.txt in2.txt
@call :dirtmp

:exit
@exit /b

:::::::::::::::::::::::::::::::
::  �뢥��� ������� ����� ��� ��ᬮ��
:dirtmp
@dir  C:\projects\tmp\resources
@exit /b

:::::::::::::::::::::::::::::::
::�訡��, ��� �� ᮧ���� ����� �஥��
:error1
@echo ��⠭���� �஥��:
@echo �஥�� ���������� � GitHub � C:\projects\Tests � ����� C:\projects\Tests. ����ࠥ��� �������� mvn clear comlile
@echo ��⥬ ����室��� � ����� C:\projects\tmp\resources ᮧ���� ����室��� 䠩��. ������ ������ ����室��� ⮫쪮 �� ����᪥ �ணࠬ�� �� ���᮫�.
@echo ����� ����� ᪮��஢��� �� ��४�ਨ C:\projects\Tests\Test2_SortingMergeFile\src\msin\java\resources. ������ �ᯮ������� �ᯮ������ �� �஢�થ �ணࠬ�� � ������� ��⮢ JUnit.

@exit /b

:::::::::::::::::::::::::::::::
::  �訡��, �᫨ �� ᮧ���� ����᭠� ������
:error2
@echo ������� ��४��� C:\projects\tmp\resources � ᮧ����� 䠩�� in*.txt ��� ����� ������ � �ணࠬ��
@exit /b


