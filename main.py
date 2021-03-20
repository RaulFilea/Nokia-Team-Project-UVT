import xml.etree.ElementTree as ET



class Reader():
    def read_file(self,file):

        tree = ET.parse(file)
        root=tree.getroot()
        return root






reader=Reader()
test1=reader.read_file("test1.xml")
for child in test1.iter('namePrecondition'):
    print(child.attrib)
    #print(child.tag)


#print(test1)

