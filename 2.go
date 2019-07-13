/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func emptycond (l *ListNode) int{
    if l!=nil{
        val:= l.Val
        l = l.Next
        return val   
    }else{
        return 0;
    }
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
    ci:=0
    head:=&ListNode{0, nil}
    curr:=head
    for l1!=nil || l2!=nil || ci>0{
        add:=ci
        if l1 != nil {
            add += l1.Val
            l1 = l1.Next
        }
        if l2 != nil {
            add += l2.Val
            l2 = l2.Next
        }
        val:=add%10
        ci = add/10
        curr.Next=new (ListNode)
        curr.Next.Val = val
        curr = curr.Next
    }
    return head.Next
}